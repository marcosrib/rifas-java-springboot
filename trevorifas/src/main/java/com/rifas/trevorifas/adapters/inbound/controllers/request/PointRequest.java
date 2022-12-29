package com.rifas.trevorifas.adapters.inbound.controllers.request;

import com.rifas.trevorifas.application.core.domain.Point;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PointRequest {
	
   private String point;
   private Long raffleId;
   private Integer userId;
   private BigDecimal value;


   public Point toPointDomain(){

      return Point.builder()
          .userId(userId)
          .raffleId(raffleId)
          .point(point)
          .value(value);
   }
}
