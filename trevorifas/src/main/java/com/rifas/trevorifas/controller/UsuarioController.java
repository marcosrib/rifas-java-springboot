package com.rifas.trevorifas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rifas.trevorifas.controller.dto.CredenciasDTO;
import com.rifas.trevorifas.controller.dto.TokenDTO;
import com.rifas.trevorifas.domain.entity.Usuario;
import com.rifas.trevorifas.exception.SenhaInvalidaException;
import com.rifas.trevorifas.security.jwt.JwtService;
import com.rifas.trevorifas.service.impl.UsuarioServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioServiceImpl service;
	private final PasswordEncoder encoder;
	private final JwtService jwtservice;

	@PostMapping("/criar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody Usuario usuario) {
		String senhaCriptografada = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		return service.salvar(usuario);

	}

	@PostMapping("/auth")
	@ResponseStatus(HttpStatus.CREATED)
	public TokenDTO autenticar(@RequestBody CredenciasDTO credencias) {

		try {
			Usuario usuario = Usuario.builder().email(credencias.getEmail()).senha(credencias.getSenha()).build();
			service.autenticar(usuario);
			String token = jwtservice.gerarToken(usuario);
			return new TokenDTO(token);
		} catch (UsernameNotFoundException | SenhaInvalidaException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

	@PutMapping("/editar")
	@ResponseStatus(HttpStatus.OK)
	public Usuario editar(@RequestBody Usuario usuario) {
		return service.editar(usuario);
	}
	
}
