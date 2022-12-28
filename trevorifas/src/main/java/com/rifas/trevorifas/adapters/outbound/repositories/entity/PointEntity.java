package com.rifas.trevorifas.adapters.outbound.repositories.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pontos")
public class PointEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "usuario_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rifa_id")
  private RaffleEntity raffle;

  @Column(name = "ponto",length = 10, nullable = false)
  private String point;

  @Column(name = "valor", precision = 10, scale = 2, nullable = false)
  private BigDecimal value;

  @Column(name = "ponto_escolhido", nullable = false)
  private boolean pointSelected;

  @Column(name = "data_criacao")
  private LocalDateTime createAt;

  @Column(name = "data_atualizacao")
  private LocalDateTime updateAt;

  @PrePersist
  public void prePersist() {
    createAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updateAt = LocalDateTime.now();
  }

}
