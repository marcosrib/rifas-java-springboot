package com.rifas.trevorifas.application.core.usecases;


import com.rifas.trevorifas.application.core.domain.Point;
import com.rifas.trevorifas.application.ports.in.points.CreatePointUseCasePort;
import com.rifas.trevorifas.application.ports.out.points.CreatePointAdapterPort;
import org.springframework.transaction.annotation.Transactional;

public class CreatePointUseCase implements CreatePointUseCasePort {

  private final CreatePointAdapterPort createPointAdapterPort;


  public CreatePointUseCase(CreatePointAdapterPort createPointAdapterPort) {
    this.createPointAdapterPort = createPointAdapterPort;
  }

  @Override
  @Transactional
  public Point create(Point point) {
    return createPointAdapterPort.create(point);
  }


}
