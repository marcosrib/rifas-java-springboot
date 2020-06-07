package com.rifas.trevorifas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.ResponsePontosDTO;

@Service
public interface PontoService {
  
	List<ResponsePontosDTO> listaPontoPorIdRifa(Long idRifa);
}
