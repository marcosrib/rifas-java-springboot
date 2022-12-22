package com.rifas.trevorifas.adapters.outbound.repositories.users;

import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.application.ports.out.users.FindUserAdapterPort;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class FindUserAdapter implements FindUserAdapterPort {
 private final UserRepository userRepository;

  public FindUserAdapter(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return Optional.of(User.convertUserEntitytoUser(userRepository.findByEmail(email).get()));
  }
}
