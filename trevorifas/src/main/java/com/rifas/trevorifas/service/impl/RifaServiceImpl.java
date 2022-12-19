package com.rifas.trevorifas.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rifas.trevorifas.controller.dto.RifaDTO;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.domain.repository.RifaRepository;
import com.rifas.trevorifas.adapters.outbound.repositories.users.UserRepository;
import com.rifas.trevorifas.service.RifaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RifaServiceImpl implements RifaService {

	private final RifaRepository rifaRepository;
	
	private final UserRepository usuarioRepository;
	
	@Override
	public Rifa salvar(RifaDTO dto) {
		
	    UserEntity userEntity = usuarioRepository.findById(dto.getIdUsuario())
		      .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
	    
		Rifa rifa =  converte(dto);
		rifa.setUserEntity(userEntity);
		return rifaRepository.save(rifa);
	}
	
	private Rifa converte(RifaDTO dto) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	    LocalDateTime dataSorteio =  LocalDateTime.parse(dto.getDataSorteio(), formatter);
	  
		return Rifa.builder()
				 .dataSorteio(dataSorteio)
				 .titulo(dto.getTitulo())
				 .valor(new BigDecimal(dto.getValor()))
				 .descricao(dto.getDescricao())
				 .tipoRifa(dto.getTipoRifa())
				 .imagem(dto.getImagem())
				 .quantidadePonto(dto.getQuantidadePonto())
				 .build();
		
	}

	@Override
	public Page<Rifa> listaRifas(Integer page) {
		int count = 10;
		Pageable pages = PageRequest.of(page - 1, count);
		return rifaRepository.findAllRifaWithPagination(pages);
	}

}
