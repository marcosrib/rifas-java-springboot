package com.rifas.trevorifas.adapters.outbound.repositories.points;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import com.rifas.trevorifas.application.core.domain.Point;
import com.rifas.trevorifas.application.ports.out.points.FindPointByRaffleIdAdapterPort;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FindPointByRaffleIdAdapter implements FindPointByRaffleIdAdapterPort {
 private final PointRepository repository;
  public FindPointByRaffleIdAdapter(PointRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Point> getPointByRaffleId(Long raffleId) {
     List<PointEntity> points = repository.findAllByRaffle(RaffleEntity.builder().id(raffleId).build());
     return convertListPointEntityToPoint(points);
  }
private List<Point> convertListPointEntityToPoint(List<PointEntity> points) {
    return  points.stream().map(pointEntity -> Point.builder()
        .point(pointEntity.getPoint())
        .value(pointEntity.getValue())
        .pointSelected(pointEntity.isPointSelected())
        .id(pointEntity.getId())
        .raffleId(pointEntity.getRaffle().getId())
        .createAt(pointEntity.getCreatedAt())
        .updateAt(pointEntity.getUpdatedAt())
        .userId(pointEntity.getUser().getId())
    ).collect(Collectors.toList());
}

}
