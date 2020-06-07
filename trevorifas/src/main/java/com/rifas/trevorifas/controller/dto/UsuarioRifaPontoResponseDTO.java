package com.rifas.trevorifas.controller.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRifaPontoResponseDTO {
	private Long id;
	private Integer idUsuario;
	private Long idRifa;
	private Integer idponto;
	private BigDecimal valor;
}
