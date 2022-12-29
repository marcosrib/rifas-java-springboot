package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Point {

  private Long id;
  private Integer userId;

  private Long raffleId;

  private String point;

  private BigDecimal value;

   private boolean pointSelected;

  private LocalDateTime createAt;

  private LocalDateTime updateAt;

    private Point() {
    }
    public static Point builder() {
      return new Point();
    }

    public Point id(Long id) {
      this.id = id;
      return this;
    }

    public Point userId(Integer userId) {
      this.userId = userId;
      return this;
    }

    public Point raffleId(Long raffleId) {
      this.raffleId = raffleId;
      return this;
    }

    public Point point(String point) {
      this.point = point;
      return this;
    }

    public Point value(BigDecimal value) {
      this.value = value;
      return this;
    }

    public Point pointSelected(boolean pointSelected) {
      this.pointSelected = pointSelected;
      return this;
    }

    public Point createAt(LocalDateTime createAt) {
      this.createAt = createAt;
      return this;
    }

    public Point updateAt(LocalDateTime updateAt) {
      this.updateAt = updateAt;
      return this;
    }

  public Long getId() {
    return id;
  }

  public Integer getUserId() {
    return userId;
  }

  public Long getRaffleId() {
    return raffleId;
  }

  public String getPoint() {
    return point;
  }

  public BigDecimal getValue() {
    return value;
  }

  public boolean isPointSelected() {
    return pointSelected;
  }

  public LocalDateTime getCreateAt() {
    return createAt;
  }

  public LocalDateTime getUpdateAt() {
    return updateAt;
  }

  public static Point convertPointEntityToUser(PointEntity point) {

    return Point.builder()
        .pointSelected(point.isPointSelected())
        .point(point.getPoint())
        .userId(point.getUser().getId())
        .id(point.getId())
        .raffleId(point.getRaffle().getId())
        .value(point.getValue());
  }

}
