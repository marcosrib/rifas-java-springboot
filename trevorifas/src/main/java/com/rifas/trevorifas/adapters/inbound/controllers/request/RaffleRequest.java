package com.rifas.trevorifas.adapters.inbound.controllers.request;

import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.core.domain.enums.EnumRaffle;
import lombok.Data;

@Data
public class RaffleRequest {

  private Long userId;

  private String raffleDate;

  private String description;

  private String title;
  private String value;

  private EnumRaffle typeRaffle;

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