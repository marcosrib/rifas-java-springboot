package com.rifas.trevorifas.application.ports.out.raffles;

import com.rifas.trevorifas.application.core.domain.Raffle;

public interface FindRaffleByIdAdapterPort {
 Raffle getRaffleById(Long id);
}
