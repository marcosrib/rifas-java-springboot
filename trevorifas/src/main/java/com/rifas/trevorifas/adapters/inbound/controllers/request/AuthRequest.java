package com.rifas.trevorifas.adapters.inbound.controllers.request;

import com.rifas.trevorifas.application.core.domain.Auth;
import com.rifas.trevorifas.application.core.domain.User;
import lombok.Data;

@Data
public class AuthRequest {
  private String email;
  private String password;
  public Auth toAuthDomain() {
    return new Auth(email,password);
  }

}
