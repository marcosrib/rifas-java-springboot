package com.rifas.trevorifas.application.ports.in.points;

import com.rifas.trevorifas.application.core.domain.Point;


public interface CreatePointUseCasePort {
	
  Point create(Point point);

}
