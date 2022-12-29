package com.rifas.trevorifas.application.ports.in.points;

import com.rifas.trevorifas.application.core.domain.Point;
import java.util.List;

public interface FindPointUseCasePort {
  List<Point> findPointsByIdRaffle(Long raffleId);
}
