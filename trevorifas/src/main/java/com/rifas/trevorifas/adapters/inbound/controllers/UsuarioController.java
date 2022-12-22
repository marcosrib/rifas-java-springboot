package com.rifas.trevorifas.adapters.inbound.controllers;

import com.rifas.trevorifas.adapters.inbound.controllers.request.UserRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.UserResponse;
import com.rifas.trevorifas.application.ports.in.users.CreateUserUseCasePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/api/usuario")
public class UsuarioController {
	private final CreateUserUseCasePort createUserUseCasePort;
	private final UsuarioServiceImpl service;
	private final JwtService jwtservice;
	public UsuarioController(CreateUserUseCasePort createUserUseCasePort, UsuarioServiceImpl service,JwtService jwtservice) {
		this.createUserUseCasePort = createUserUseCasePort;
		this.service=service;
		this.jwtservice = jwtservice;
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserResponse>  create(@RequestBody UserRequest userRequest) {
		return ResponseEntity.ok().body(UserResponse.fromDomain(createUserUseCasePort.create(userRequest.toUserDomain())));
	}

	@PostMapping("/auth")
	@ResponseStatus(HttpStatus.OK)
	public TokenDTO autenticar(@RequestBody CredenciasDTO credencias) {

		try {
			UserEntity userEntity = UserEntity.builder().email(credencias.getEmail()).senha(credencias.getSenha()).build();
			service.autenticar(userEntity);
			String token = jwtservice.gerarToken(userEntity);
			return new TokenDTO(token);
		} catch (UsernameNotFoundException | SenhaInvalidaException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

	@PutMapping("/editar")
	@ResponseStatus(HttpStatus.OK)
	public UserEntity editar(@RequestBody UserEntity userEntity) {
		return null;
	}
	
}
