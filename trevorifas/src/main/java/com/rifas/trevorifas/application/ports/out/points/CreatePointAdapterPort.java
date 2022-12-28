package com.rifas.trevorifas.application.ports.out.points;

import com.rifas.trevorifas.application.core.domain.Point;

public interface CreatePointAdapterPort {

  Point create(Point point);
}
