package com.rifas.trevorifas.adapters.outbound.repositories.Raffles;

import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.ports.out.raffles.FindRaffleByIdAdapterPort;
import com.rifas.trevorifas.exception.RegraNegocioException;
import org.springframework.stereotype.Component;

@Component
public class FindRaffleByIdAdapter implements FindRaffleByIdAdapterPort {

  private final RaffleRepository raffleRepository;

  public FindRaffleByIdAdapter(RaffleRepository raffleRepository) {
    this.raffleRepository = raffleRepository;
  }

  @Override
  public Raffle getRaffleById(Long id) {
    return raffleRepository.findById(id).map(raffleEntity -> Raffle
            .builder()
            .id(raffleEntity.getId())
            .title(raffleEntity.getTitle())
            .pointQuantity(raffleEntity.getPointQuantity())
            .value(raffleEntity.getValue().toString())
        ).orElseThrow(() -> new RegraNegocioException("Rifa não encontrada"));
  }
}
