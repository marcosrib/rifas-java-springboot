package com.rifas.trevorifas.application.core.usecases;

import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.ports.in.raffles.CreateRaffleUseCasePort;
import com.rifas.trevorifas.application.ports.out.raffles.CreateRaffleAdapterPort;

public class CreateRaffleUseCase  implements CreateRaffleUseCasePort {

  private final CreateRaffleAdapterPort createRaffleAdapterPort;

  public CreateRaffleUseCase(CreateRaffleAdapterPort createRaffleAdapterPort) {
    this.createRaffleAdapterPort = createRaffleAdapterPort;
  }

  @Override
  public Raffle create(Raffle raffle) {
    return createRaffleAdapterPort.create(raffle);
  }
}
