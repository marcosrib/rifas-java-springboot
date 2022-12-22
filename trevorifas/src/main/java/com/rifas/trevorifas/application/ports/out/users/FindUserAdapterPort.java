package com.rifas.trevorifas.application.ports.out.users;


import com.rifas.trevorifas.application.core.domain.User;
import java.util.Optional;


public interface FindUserAdapterPort {
  Optional<User> findByEmail(String email);
}
