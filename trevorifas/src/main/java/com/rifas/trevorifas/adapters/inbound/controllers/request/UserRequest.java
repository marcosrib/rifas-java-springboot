package com.rifas.trevorifas.adapters.inbound.controllers.request;

import com.rifas.trevorifas.application.core.domain.Profile;
import com.rifas.trevorifas.application.core.domain.User;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class UserRequest {

  private String name;
  private String email;
  private String password;

  private Set<Profile> profiles;

  public User toUserDomain() {

    Set<Profile> profilesList = new HashSet<>();
    profilesList.addAll(profiles);
    return new User(name, email, password, profilesList);
  }

}
