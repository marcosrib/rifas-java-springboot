package com.rifas.trevorifas.adapters.outbound.repositories.entity;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rifas.trevorifas.application.core.domain.enums.EnumRaffle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "raffles")
public class RaffleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;


  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "raffle_date", nullable = false)
  private LocalDateTime raffleDate;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "title", length = 50, nullable = false)
  private String title;
  @Column(name = "image_name")
  private String imageName;

  @Column(name = "point_quantity", length = 10, nullable = false)
  private Integer pointQuantity;

  @Column(name = "valuer", precision = 10, scale = 2, nullable = false)
  private BigDecimal value;

  @Enumerated(EnumType.STRING)
  @Column(name = "type_raffle", length = 50)
  private EnumRaffle typeRaffle;

  @JsonIgnore
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity userEntity;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }

}
