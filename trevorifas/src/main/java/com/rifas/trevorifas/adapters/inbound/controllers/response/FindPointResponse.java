package com.rifas.trevorifas.adapters.inbound.controllers.response;

import com.rifas.trevorifas.application.core.domain.Point;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindPointResponse {

  private Long pointId;
  private String point;
  private Long userId;
  private BigDecimal value;
  private boolean pointSelected;

  public static List<FindPointResponse> convertListPointDomainToListResponse(List<Point> points) {
    return points.stream().map(
        point -> new FindPointResponse(point.getId(), point.getPoint(), point.getUserId(),
            point.getValue(), point.isPointSelected())).collect(
        Collectors.toList());
  }
}
