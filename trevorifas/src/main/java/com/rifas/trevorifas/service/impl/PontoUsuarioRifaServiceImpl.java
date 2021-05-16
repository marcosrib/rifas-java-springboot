package com.rifas.trevorifas.service.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rifas.trevorifas.controller.dto.UsuarioRifaPontoDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.domain.repository.RifaRepository;
import com.rifas.trevorifas.domain.repository.UsuarioRepository;
import com.rifas.trevorifas.domain.repository.PontoRepository;
import com.rifas.trevorifas.service.PontoUsuarioRifaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PontoUsuarioRifaServiceImpl implements PontoUsuarioRifaService {

	private final PontoRepository repository;
	
	private final RifaRepository rifaRepository;
	
	private final UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public Ponto salvar(UsuarioRifaPontoDTO dto) {
		/*
		Ponto ponto = pontoRepository.findById(dto.getIdPonto()).get();
		
		Rifa rifa =  rifaRepository.findById(dto.getIdRifa()).get();
		
		Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).get();
		;*/
		Ponto urp = new Ponto();
		//urp.setPonto(ponto);
		//urp.setRifa(rifa);
		//urp.setUsuario(usuario);
		urp.setValor(new BigDecimal(dto.getValor()));
		
		return repository.save(urp);
	}

	@Override
	public List<Ponto> buscarPontoUsuarioRifaPorIdRifa(Long idRifa) {
		//return repository.findByIdRifa(idRifa);
		return null;
	}
}
