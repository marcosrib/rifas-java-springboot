package com.rifas.trevorifas.service.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rifas.trevorifas.controller.dto.UsuarioRifaPontoDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.domain.entity.Usuario;
import com.rifas.trevorifas.domain.entity.UsuarioRifaPonto;
import com.rifas.trevorifas.domain.repository.PontoRepository;
import com.rifas.trevorifas.domain.repository.RifaRepository;
import com.rifas.trevorifas.domain.repository.UsuarioRepository;
import com.rifas.trevorifas.domain.repository.UsuarioRifaPontoRepository;
import com.rifas.trevorifas.service.UsuarioRifaPontoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioRifaPontoServiceImpl implements UsuarioRifaPontoService {

	private final UsuarioRifaPontoRepository repository;
	
	private final PontoRepository pontoRepository;
	
	private final RifaRepository rifaRepository;
	
	private final UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public UsuarioRifaPonto salvar(UsuarioRifaPontoDTO dto) {
		
		Ponto ponto = pontoRepository.findById(dto.getIdPonto()).get();
		
		Rifa rifa =  rifaRepository.findById(dto.getIdRifa()).get();
		
		Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).get();
		
		UsuarioRifaPonto urp = new UsuarioRifaPonto();
		urp.setPonto(ponto);
		urp.setRifa(rifa);
		urp.setUsuario(usuario);
		urp.setValor(new BigDecimal(dto.getValor()));
		
		return repository.save(urp);
	}
  
}
