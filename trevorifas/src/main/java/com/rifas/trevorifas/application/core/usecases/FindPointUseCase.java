package com.rifas.trevorifas.application.core.usecases;

import com.rifas.trevorifas.application.core.domain.Point;
import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.ports.in.points.FindPointUseCasePort;
import com.rifas.trevorifas.application.ports.out.points.FindPointByRaffleIdAdapterPort;
import com.rifas.trevorifas.application.ports.out.raffles.FindRaffleByIdAdapterPort;
import com.rifas.trevorifas.common.util.FormatNumber;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPointUseCase implements FindPointUseCasePort {

  private static final Integer RANGE_INITIAL = 0;
  private final FindPointByRaffleIdAdapterPort findPointByRaffleIdAdapterPort;

  private final FindRaffleByIdAdapterPort findRaffleByIdAdapterPort;

  public FindPointUseCase(FindPointByRaffleIdAdapterPort findPointByRaffleIdAdapterPort,
      FindRaffleByIdAdapterPort findRaffleByIdAdapterPort) {
    this.findPointByRaffleIdAdapterPort = findPointByRaffleIdAdapterPort;
    this.findRaffleByIdAdapterPort = findRaffleByIdAdapterPort;
  }

  @Override
  public List<Point> findPointsByIdRaffle(Long raffleId) {
    Raffle raffle = findRaffleByIdAdapterPort.getRaffleById(raffleId);

    List<Point> points = findPointByRaffleIdAdapterPort.getPointByRaffleId(raffleId);

    IntStream rangePoints = IntStream.range(RANGE_INITIAL, raffle.getPointQuantity());
    return rangePoints.mapToObj(point -> {
      Optional<Point> pointSelected = filterPointByPointId(points, point);
      if (pointSelected.isPresent()) {
        return pointSelected.get();
      }
      return Point.builder().point(String.valueOf(point));
    }).collect(Collectors.toList());

  }


  private Optional<Point> filterPointByPointId(List<Point> points, int point) {
    return points.stream()
        .filter(p -> p.getPoint().equals(FormatNumber.addZeroLeft(point))).findAny();
  }

}
