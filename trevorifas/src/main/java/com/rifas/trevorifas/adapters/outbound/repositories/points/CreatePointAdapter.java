package com.rifas.trevorifas.adapters.outbound.repositories.points;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.application.core.domain.Point;
import com.rifas.trevorifas.application.ports.out.points.CreatePointAdapterPort;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import org.springframework.stereotype.Component;

@Component
public class CreatePointAdapter implements CreatePointAdapterPort {

  private final PointRepository pointRepository;

  public CreatePointAdapter(PointRepository pointRepository) {
    this.pointRepository = pointRepository;
  }

  @Override
  public Point create(Point point) {
   PointEntity pointEntity =  PointEntity.builder()
        .raffle(RaffleEntity.builder().id(point.getRaffleId()).build())
        .value(point.getValue())
        .user(UserEntity.builder().id(point.getUserId()).build())
        .point(point.getPoint())
        .build();
    return Point.convertPointEntityToUser(pointRepository.save(pointEntity));
  }
}
