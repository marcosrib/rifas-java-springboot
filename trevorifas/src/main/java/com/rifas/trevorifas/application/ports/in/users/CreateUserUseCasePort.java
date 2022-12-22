package com.rifas.trevorifas.application.ports.in.users;

import com.rifas.trevorifas.application.core.domain.User;

public interface CreateUserUseCasePort {
  User create(User user);
}
