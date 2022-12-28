package com.rifas.trevorifas.adapters.inbound.controllers.request;

import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.core.domain.enums.EnumRifa;
import lombok.Data;

@Data
public class RaffleRequest {

  private Integer userId;

  private String raffleDate;

  private String description;

  private String title;
  private String value;

  private EnumRifa typeRaffle;

  private Integer pointQuantity;


  public Raffle toRaffleDomain() {
    return  Raffle.builder()
        .value(value)
        .title(title)
        .typeRaffle(typeRaffle)
        .raffleDate(raffleDate)
        .pointQuantity(pointQuantity)
        .description(description)
        .userId(userId);
  }
}