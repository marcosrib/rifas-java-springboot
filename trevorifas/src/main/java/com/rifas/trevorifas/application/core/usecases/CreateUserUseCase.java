package com.rifas.trevorifas.application.core.usecases;

import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.application.ports.in.CreateUserUseCasePort;
import com.rifas.trevorifas.application.ports.out.CreateUserAdapterPort;
import com.rifas.trevorifas.domain.enums.EnumPerfil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


public class CreateUserUseCase implements CreateUserUseCasePort {

  private final CreateUserAdapterPort createUserAdapterPort;
  private final PasswordEncoder encoder;

  public CreateUserUseCase(CreateUserAdapterPort createUserAdapterPort, PasswordEncoder encoder) {
    this.createUserAdapterPort = createUserAdapterPort;
    this.encoder = encoder;
  }

  @Override
  public User create(User user) {
    List<String> listProfilesByIds = new ArrayList<String>();

    if (!user.getProfiles().isEmpty()) {
      user.getProfiles().forEach(perfil -> listProfilesByIds.add(perfil.getNome()));
    } else {
      listProfilesByIds.add(EnumPerfil.USER.toString());
    }
    String encryptPassword = encoder.encode(user.getPassword());
    user.setPassword(encryptPassword);
    return createUserAdapterPort.create(user);
  }
}
