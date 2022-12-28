package com.rifas.trevorifas.adapters.outbound.repositories.entity;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rifas.trevorifas.application.core.domain.enums.EnumRifa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rifas")
public class RaffleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "data_criacao", nullable = false)
  private LocalDateTime createAt;


  @Column(name = "data_atualizacao")
  private LocalDateTime updateAt;

  @Column(name = "data_sorteio", nullable = false)
  private LocalDateTime raffleDate;

  @Column(name = "descricao", nullable = false)
  private String description;

  @Column(name = "titulo", length = 50, nullable = false)
  private String title;
  @Column(name = "imagem")
  private String imageName;

  @Column(name = "quantidade_ponto", length = 10, nullable = false)
  private Integer pointQuantity;

  @Column(name = "valor", precision = 10, scale = 2, nullable = false)
  private BigDecimal value;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_rifa", length = 50)
  private EnumRifa typeRaffle;

  @JsonIgnore
  @ManyToOne(optional = false)
  @JoinColumn(name = "usuario_id", nullable = false)
  private UserEntity userEntity;

  @PrePersist
  public void prePersist() {
    createAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updateAt = LocalDateTime.now();
  }

}
