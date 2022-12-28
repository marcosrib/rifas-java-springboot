package com.rifas.trevorifas.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.RifaDTO;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;

@Service
public interface RifaService {

	RaffleEntity salvar(RifaDTO rifa);
	
	Page<RaffleEntity> listaRifas(Integer page);
}
