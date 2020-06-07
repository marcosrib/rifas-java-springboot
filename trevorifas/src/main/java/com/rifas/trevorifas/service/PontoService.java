package com.rifas.trevorifas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;

@Service
public interface PontoService {
  
	List<PontoResponseDTO> listaPontoPorIdRifa(Long idRifa);
}
