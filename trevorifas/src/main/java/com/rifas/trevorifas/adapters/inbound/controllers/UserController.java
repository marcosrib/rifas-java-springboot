package com.rifas.trevorifas.adapters.inbound.controllers;

import com.rifas.trevorifas.adapters.inbound.controllers.request.UserRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.UserResponse;
import com.rifas.trevorifas.adapters.inbound.controllers.swagger.api.UserApi;
import com.rifas.trevorifas.application.ports.in.users.CreateUserUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rifas.trevorifas.controller.dto.CredenciasDTO;
import com.rifas.trevorifas.controller.dto.TokenDTO;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.exception.SenhaInvalidaException;
import com.rifas.trevorifas.security.jwt.JwtService;
import com.rifas.trevorifas.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController  implements UserApi {
	private final CreateUserUseCasePort createUserUseCasePort;
	private final UsuarioServiceImpl service;

	public UserController(CreateUserUseCasePort createUserUseCasePort, UsuarioServiceImpl service,JwtService jwtservice) {
		this.createUserUseCasePort = createUserUseCasePort;
		this.service=service;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponse  create(@RequestBody UserRequest userRequest) {
		return UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));
	}



	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse update(@RequestBody UserRequest userRequest) {
		return  UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain()));
	}
	
}
