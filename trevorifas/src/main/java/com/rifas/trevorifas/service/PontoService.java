package com.rifas.trevorifas.service;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.PontoDTO;
import com.rifas.trevorifas.domain.entity.Ponto;

@Service
public interface PontoService {
	
  Ponto salvar(PontoDTO dto);

}
