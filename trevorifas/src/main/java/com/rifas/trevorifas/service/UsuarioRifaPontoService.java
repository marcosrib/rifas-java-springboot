package com.rifas.trevorifas.service;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.UsuarioRifaPontoDTO;
import com.rifas.trevorifas.domain.entity.UsuarioRifaPonto;

@Service
public interface UsuarioRifaPontoService {
	
  UsuarioRifaPonto salvar(UsuarioRifaPontoDTO dto);
}
