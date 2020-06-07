package com.rifas.trevorifas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.service.PontoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ponto")
@RequiredArgsConstructor
public class PontoController {

	private final PontoService service;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<PontoResponseDTO> listar(@PathVariable Long id) {
		return service.listaPontoPorIdRifa(id);
	}
}
