package com.rifas.trevorifas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.trevorifas.domain.entity.Usuario;
import com.rifas.trevorifas.service.impl.UsuarioServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioServiceImpl service;
	private final PasswordEncoder encoder;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody Usuario usuario) {
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		return service.salvar(usuario);
		
	}
}
