package com.rifas.trevorifas.application.core.usecases;

import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.application.ports.in.users.CreateUserUseCasePort;
import com.rifas.trevorifas.application.ports.out.profiles.FindProfileAdapterPort;
import com.rifas.trevorifas.application.ports.out.users.CreateUserAdapterPort;
import com.rifas.trevorifas.application.core.domain.enums.EnumProfile;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;


public class CreateUserUseCase implements CreateUserUseCasePort {

  private final CreateUserAdapterPort createUserAdapterPort;

  private final FindProfileAdapterPort findProfileAdapterPort;
  private final PasswordEncoder encoder;

  public CreateUserUseCase(CreateUserAdapterPort createUserAdapterPort, FindProfileAdapterPort findProfileAdapterPort, PasswordEncoder encoder) {
    this.createUserAdapterPort = createUserAdapterPort;
    this.findProfileAdapterPort = findProfileAdapterPort;
    this.encoder = encoder;
  }

  @Override
  public User create(User user) {
    List<String> listProfilesName = new ArrayList<String>();
    if (!user.getProfiles().isEmpty()) {
      user.getProfiles().forEach(profile -> listProfilesName.add(profile.getName().toString()));
    } else {
      listProfilesName.add(EnumProfile.USER.toString());
    }
    String encryptPassword = encoder.encode(user.getPassword());
    user.setPassword(encryptPassword);
    user.setProfiles( findProfileAdapterPort.findProfileByNameIn(listProfilesName));
    return createUserAdapterPort.create(user);
  }
}
