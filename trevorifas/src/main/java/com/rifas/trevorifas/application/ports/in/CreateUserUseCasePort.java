package com.rifas.trevorifas.application.ports.in;

import com.rifas.trevorifas.application.core.domain.User;

public interface CreateUserUseCasePort {
  User create(User user);
}
