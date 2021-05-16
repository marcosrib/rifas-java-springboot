package com.rifas.trevorifas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PontoResponseDTO {
	private Long idPonto;
	private String  ponto;
	private Integer idUsuario;
	private String valor;
	private boolean pontoEscolhido;
	
	
}
