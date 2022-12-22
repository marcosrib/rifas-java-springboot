package com.rifas.trevorifas.adapters.inbound.controllers.response;

import com.rifas.trevorifas.application.core.domain.Profile;
import com.rifas.trevorifas.application.core.domain.User;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

  private Integer id;
  private String name;
  private String email;
  private Set<Profile> profiles;

  public UserResponse() {

  }

  public UserResponse(Integer id, String name, String email,
      Set<Profile> profiles) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.profiles = profiles;
  }

  public static UserResponse fromDomain(User user) {
    return new UserResponse(user.getId(), user.getName(), user.getEmail(),
        user.getProfiles());
  }
}
