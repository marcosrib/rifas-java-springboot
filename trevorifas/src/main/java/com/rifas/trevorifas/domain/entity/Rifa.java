package com.rifas.trevorifas.domain.entity;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rifas.trevorifas.domain.enums.EnumRifa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rifa")
public class Rifa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_criacao",  nullable = false)
	private LocalDateTime dataCriacao;


	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;

	@Column(name = "data_sorteio", nullable = false)
	private LocalDateTime dataSorteio;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "titulo",length = 50, nullable = false)
	private String titulo;
	
	private String imagem;

	@Column(name = "quantidade_ponto", length = 10, nullable = false)
	private Integer quantidadePonto;

	@Column(name = "valor", precision = 10, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_rifa", length =  50)
    private EnumRifa tipoRifa;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario  usuario;
	
	@PrePersist
	public void prePersist() {
		dataCriacao = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		dataCriacao = LocalDateTime.now();
	}
	
}
