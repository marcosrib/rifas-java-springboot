package com.rifas.trevorifas.adapters.inbound.controllers.response;

import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.domain.entity.Perfil;
import java.util.HashSet;
import java.util.Set;

public class UserResponse {

  private Integer id;
  private String name;
  private String email;
  private String password;
  private Set<Perfil> profiles;

  public UserResponse() {

  }

  public UserResponse(Integer id, String name, String email, String password,
      Set<Perfil> profiles) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.profiles = profiles;
  }

  public static UserResponse fromDomain(User user) {
     Set<Perfil> profile = new HashSet<>();
     profile.addAll(user.getProfiles());
     return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getPassword(), profile);

  }
}
