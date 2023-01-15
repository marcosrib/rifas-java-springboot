package com.rifas.trevorifas.application.core.usecases;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.ProfileEntity;
import com.rifas.trevorifas.application.core.domain.Profile;
import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.application.ports.in.users.CreateUserUseCasePort;
import com.rifas.trevorifas.application.ports.out.profiles.FindProfileAdapterPort;
import com.rifas.trevorifas.application.ports.out.users.CreateUserAdapterPort;
import com.rifas.trevorifas.application.core.domain.enums.EnumProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    List<EnumProfile> listProfilesName = new ArrayList<EnumProfile>();
    if (!user.getProfiles().isEmpty()) {
      user.getProfiles().forEach(profile -> listProfilesName.add(profile.getName()));
    } else {
      listProfilesName.add(EnumProfile.USER);
    }
    String encryptPassword = encoder.encode(user.getPassword());
    Set<Profile> profiles =  findProfileAdapterPort.findProfileByNameIn(listProfilesName);
    user.setPassword(encryptPassword);
    user.setProfiles(profiles);
    return createUserAdapterPort.create(user);
  }
}
