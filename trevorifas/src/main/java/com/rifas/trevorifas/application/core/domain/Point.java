package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class Point {

  private Long id;
  private Integer userId;

  private Long raffleId;

  private String point;

  private BigDecimal value;

  private LocalDateTime createAt;

  private LocalDateTime updateAt;

  public Point(Integer userId, Long raffleId, String point, BigDecimal value) {
    this.userId = userId;
    this.raffleId = raffleId;
    this.point = point;
    this.value = value;
  }

  public Point(Long id, Integer userId, Long raffleId, String point, BigDecimal value,
      LocalDateTime createAt, LocalDateTime updateAt) {
    this.id = id;
    this.userId = userId;
    this.raffleId = raffleId;
    this.point = point;
    this.value = value;
    this.createAt = createAt;
    this.updateAt = updateAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Long getRaffleId() {
    return raffleId;
  }

  public void setRaffleId(Long raffleId) {
    this.raffleId = raffleId;
  }

  public String getPoint() {
    return point;
  }

  public void setPoint(String point) {
    this.point = point;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public LocalDateTime getCreateAt() {
    return createAt;
  }

  public void setCreateAt(LocalDateTime createAt) {
    this.createAt = createAt;
  }

  public LocalDateTime getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(LocalDateTime updateAt) {
    this.updateAt = updateAt;
  }

  public static Point convertPointEntityToUser(PointEntity point) {

    return new Point(point.getId(), point.getUser().getId(), point.getRaffle().getId(),
        point.getPoint(), point.getValue(), point.getCreateAt(), point.getUpdateAt());
  }
}
