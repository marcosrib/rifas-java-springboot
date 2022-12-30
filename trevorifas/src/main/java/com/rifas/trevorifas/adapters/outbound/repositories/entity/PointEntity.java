package com.rifas.trevorifas.adapters.outbound.repositories.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "points")
@Where(clause = "deleted_at is null")
public class PointEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "raffle_id")
  private RaffleEntity raffle;

  @Column(name = "point",length = 10, nullable = false)
  private String point;

  @Column(name = "value", precision = 10, scale = 2, nullable = false)
  private BigDecimal value;

  @Column(name = "point_selected", nullable = false)
  private boolean pointSelected;

  @Column(name = "create_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }

}
