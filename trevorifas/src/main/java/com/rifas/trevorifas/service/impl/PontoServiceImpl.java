package com.rifas.trevorifas.service.impl;


import com.rifas.trevorifas.mapper.CriarPontoMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rifas.trevorifas.controller.dto.PontoDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.domain.repository.PontoRepository;
import com.rifas.trevorifas.service.PontoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PontoServiceImpl implements PontoService {

	private final PontoRepository repository;

	private final CriarPontoMapperService criarPontoMapperService;

	@Override
	@Transactional
	public Ponto salvar(PontoDTO dto) {
		return repository.save(criarPontoMapperService.convertePontoDTOParaPontoEntity(dto));
	}


}
