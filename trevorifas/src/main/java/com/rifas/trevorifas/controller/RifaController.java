package com.rifas.trevorifas.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.trevorifas.controller.dto.RifaDTO;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.service.RifaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rifa")
@RequiredArgsConstructor
public class RifaController {

	private final RifaService service;

	@PostMapping("/criar")
	@ResponseStatus(HttpStatus.CREATED)
	public Rifa salvar(@RequestBody RifaDTO dto) {
		return service.salvar(dto);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Rifa> listar(@RequestParam Integer page) {
		System.err.println(page);
		return service.listaRifas(page);
	}
}
