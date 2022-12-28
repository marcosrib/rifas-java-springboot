package com.rifas.trevorifas.application.ports.in.raffles;

import com.rifas.trevorifas.application.core.domain.Raffle;

public interface CreateRaffleUseCasePort {
  Raffle create(Raffle raffle);
}
