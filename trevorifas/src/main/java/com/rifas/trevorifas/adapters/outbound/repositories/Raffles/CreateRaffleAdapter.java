package com.rifas.trevorifas.adapters.outbound.repositories.Raffles;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.ports.out.raffles.CreateRaffleAdapterPort;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CreateRaffleAdapter implements CreateRaffleAdapterPort {

  private final RaffleRepository repository;

  public CreateRaffleAdapter(RaffleRepository repository) {
    this.repository = repository;
  }

  @Override
  public Raffle create(Raffle raffle) {
   RaffleEntity raffleEntity =  RaffleEntity.builder()
        .raffleDate(LocalDateTime.now())
        .typeRaffle(raffle.getTypeRaffle())
        .title(raffle.getTitle())
        .value(new BigDecimal(raffle.getValue()))
        .pointQuantity(raffle.getPointQuantity())
       .userEntity(UserEntity.builder().id(raffle.getUserId()).build())
       .description(raffle.getDescription())
        .build();
    return  convertReffleEntityToRaffle(  repository.save(raffleEntity));
  }

  private Raffle convertReffleEntityToRaffle(RaffleEntity  raffleEntity) {
    return Raffle.builder()
        .userId(raffleEntity.getUserEntity().getId())
        .description(raffleEntity.getDescription())
        .typeRaffle(raffleEntity.getTypeRaffle())
        .raffleDate(raffleEntity.getRaffleDate().toString())
        .pointQuantity(raffleEntity.getPointQuantity())
        .title(raffleEntity.getTitle())
        .value(raffleEntity.getValue().toString());
  }
}
