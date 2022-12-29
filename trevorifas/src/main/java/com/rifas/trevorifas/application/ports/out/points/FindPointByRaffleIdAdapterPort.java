package com.rifas.trevorifas.application.ports.out.points;

import com.rifas.trevorifas.application.core.domain.Point;
import java.util.List;

public interface FindPointByRaffleIdAdapterPort {
   List<Point>  getPointByRaffleId(Long raffleId);
}
