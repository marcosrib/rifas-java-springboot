package com.rifas.trevorifas.adapters.inbound.controllers;

import com.rifas.trevorifas.adapters.inbound.controllers.request.AuthRequest;

import com.rifas.trevorifas.application.ports.in.auth.AuthUseCasePort;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthUseCasePort authUseCasePort;

  public AuthController(AuthUseCasePort authUseCasePort) {
    this.authUseCasePort = authUseCasePort;
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public String auth(@RequestBody AuthRequest credencias) {
   return authUseCasePort.auth(credencias.toAuthDomain());
  }
}
