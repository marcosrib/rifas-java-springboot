package com.rifas.trevorifas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.domain.entity.Ponto;

@Service
public interface PontoService {
  
	List<Ponto> listaPontoPorIdRifa(Long idRifa);
}
