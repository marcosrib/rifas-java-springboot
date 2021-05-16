package com.rifas.trevorifas.service;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.UsuarioRifaPontoDTO;
import com.rifas.trevorifas.domain.entity.Ponto;

import java.util.List;

@Service
public interface PontoUsuarioRifaService {
	
  Ponto salvar(UsuarioRifaPontoDTO dto);

  List<Ponto> buscarPontoUsuarioRifaPorIdRifa(Long idRifa);
}
