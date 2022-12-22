package com.rifas.trevorifas.application.ports.in.auth;

import com.rifas.trevorifas.application.core.domain.Auth;


public interface AuthUseCasePort {
  String auth(Auth auth);
}
