package com.rifas.trevorifas.adapters.inbound.controllers.response;

import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.core.domain.enums.EnumRaffle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RaffleResponse {
  private Long userId;

  private String raffleDate;

  private String description;

  private String title;
  private String value;

  private String imageName;

  private EnumRaffle typeRaffle;

  private Integer pointQuantity;
  public static RaffleResponse fromDomain(Raffle raffle) {
    return RaffleResponse.builder()
        .description(raffle.getDescription())
        .raffleDate(raffle.getRaffleDate())
        .pointQuantity(raffle.getPointQuantity())
        .title(raffle.getTitle())
        .typeRaffle(raffle.getTypeRaffle())
        .userId(raffle.getUserId())
        .value(raffle.getValue())
        .build();
  }
}
