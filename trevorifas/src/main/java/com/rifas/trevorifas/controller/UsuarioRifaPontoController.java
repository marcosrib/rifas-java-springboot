package com.rifas.trevorifas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.trevorifas.controller.dto.UsuarioRifaPontoDTO;
import com.rifas.trevorifas.controller.dto.UsuarioRifaPontoResponseDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.service.PontoUsuarioRifaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/urp")
@RequiredArgsConstructor
public class UsuarioRifaPontoController {

	private final PontoUsuarioRifaService service;

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioRifaPontoResponseDTO salvar(@RequestBody UsuarioRifaPontoDTO dto) {
		  
		Ponto urp = service.salvar(dto);
		  
		return UsuarioRifaPontoResponseDTO
		  		.builder()
		  		.id(urp.getId())
		  		.idRifa(urp.getRifa().getId())
		  		.idUsuario(urp.getUsuario().getId())
		  		.valor(urp.getValor())
		  		.build();
	}
	
}
