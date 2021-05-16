package com.rifas.trevorifas.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "pontos")
public class Ponto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rifa_id")
	private Rifa rifa;

	@Column( length = 10, nullable = false)
	private String ponto;

	@Column(name = "valor", precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;

	@Column(name = "ponto_escolhido",  nullable = false)
	private boolean pontoEscolhido;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;

	@PrePersist
	public void prePersist() {
      dataCriacao = LocalDateTime.now();
	}

    @PreUpdate
	public void preUpdate() {
		dataCriacao = LocalDateTime.now();
	}

}
