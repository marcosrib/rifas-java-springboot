package com.rifas.trevorifas.adapters.inbound.controllers;

import com.rifas.trevorifas.adapters.inbound.controllers.request.UserRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.UserResponse;
import com.rifas.trevorifas.adapters.inbound.controllers.swagger.api.UserApi;
import com.rifas.trevorifas.application.ports.in.users.CreateUserUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController implements UserApi {

  private final CreateUserUseCasePort createUserUseCasePort;


  public UserController(CreateUserUseCasePort createUserUseCasePort) {
    this.createUserUseCasePort = createUserUseCasePort;

  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse create(@RequestBody UserRequest userRequest) {
    return UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));
  }


  @PutMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public UserResponse update(@RequestBody UserRequest userRequest) {
    return UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));
  }

}
