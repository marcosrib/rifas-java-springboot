package com.rifas.trevorifas.controller.dto;

import com.rifas.trevorifas.application.core.domain.enums.EnumRaffle;

import lombok.Data;

@Data
public class RifaDTO {
   
	private Integer idUsuario;
	
	private String dataSorteio;
	
	private String descricao;
	
	private String titulo;
	
	private String imagem;
	
	private String valor;
	
	private EnumRaffle tipoRifa;

	private Integer quantidadePonto;
}
