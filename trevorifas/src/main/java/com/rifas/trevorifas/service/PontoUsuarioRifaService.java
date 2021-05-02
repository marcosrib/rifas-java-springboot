package com.rifas.trevorifas.service;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.UsuarioRifaPontoDTO;
import com.rifas.trevorifas.domain.entity.PontoUsuarioRifa;

import java.util.List;

@Service
public interface PontoUsuarioRifaService {
	
  PontoUsuarioRifa salvar(UsuarioRifaPontoDTO dto);

  List<PontoUsuarioRifa> buscarPontoUsuarioRifaPorIdRifa(Long idRifa);
}
