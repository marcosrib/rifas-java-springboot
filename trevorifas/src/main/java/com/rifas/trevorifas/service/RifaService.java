package com.rifas.trevorifas.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.RifaDTO;
import com.rifas.trevorifas.domain.entity.Rifa;

@Service
public interface RifaService {

	Rifa salvar(RifaDTO rifa);
	
	Page<Rifa> listarPoIdUsuario(Integer idUsuario, Integer page);
}
