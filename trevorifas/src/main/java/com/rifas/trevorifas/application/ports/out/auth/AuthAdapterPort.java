package com.rifas.trevorifas.application.ports.out.auth;

import com.rifas.trevorifas.application.core.domain.Auth;
import org.springframework.security.core.userdetails.UserDetails;


public interface AuthAdapterPort {
  String authenticate(Auth auth);
  UserDetails loadUserByUsername(String email);
}
