package com.rifas.trevorifas.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario_rifa_ponto")
public class UsuarioRifaPonto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rifa_id")
	private Rifa rifa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ponto_id")
	private Ponto ponto;

	@Column(name = "valor", precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;

}
