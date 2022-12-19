package com.rifas.trevorifas.adapters.inbound.controllers.request;

import com.rifas.trevorifas.adapters.inbound.controllers.response.UserResponse;
import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.domain.entity.Perfil;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class UserRequest {

  private String name;
  private String email;
  private String password;

  private Set<Perfil> profiles;

  public User toUserDomain() {

    Set<Perfil> profilesList = new HashSet<>();
    profilesList.addAll(profiles);
    return new User(name, email, password, profilesList);
  }

}
