package com.rifas.trevorifas.application.core.usecases;

import antlr.StringUtils;
import com.rifas.trevorifas.application.core.domain.Auth;
import com.rifas.trevorifas.application.ports.in.auth.AuthUseCasePort;
import com.rifas.trevorifas.application.ports.out.auth.AuthAdapterPort;
import com.rifas.trevorifas.exception.SenhaInvalidaException;

public class AuthUseCase implements AuthUseCasePort {
  private AuthAdapterPort authAdapterPort;

  public AuthUseCase(AuthAdapterPort authAdapterPort) {
    this.authAdapterPort = authAdapterPort;
  }

  public String auth(Auth auth) {
    String token =  authAdapterPort.authenticate(auth);
    if(token == null) {
      throw new SenhaInvalidaException();
    }
   return token;
  }


}
