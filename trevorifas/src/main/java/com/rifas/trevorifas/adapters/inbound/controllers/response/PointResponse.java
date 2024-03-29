package com.rifas.trevorifas.adapters.inbound.controllers.response;

import com.rifas.trevorifas.application.core.domain.Point;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointResponse {

  private Long id;
  private Long userId;

  private Long raffleId;

  private String point;

  private boolean pointSelected;

  private BigDecimal value;

  private LocalDateTime createAt;

  private LocalDateTime updateAt;

  public PointResponse(Long id, Long userId, Long raffleId, String point, BigDecimal value,
      LocalDateTime createAt, LocalDateTime updateAt, boolean pointSelected) {
    this.id = id;
    this.userId = userId;
    this.raffleId = raffleId;
    this.point = point;
    this.value = value;
    this.createAt = createAt;
    this.updateAt = updateAt;
    this.pointSelected = pointSelected;
  }

  public static PointResponse fromDomain(Point point) {
    return new PointResponse(point.getId(), point.getUserId(), point.getRaffleId(),
        point.getPoint(), point.getValue(), point.getCreateAt(), point.getUpdateAt(), point.isPointSelected());
  }
}
