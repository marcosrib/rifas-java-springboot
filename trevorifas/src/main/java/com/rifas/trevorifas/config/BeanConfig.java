package com.rifas.trevorifas.config;

import com.rifas.trevorifas.application.core.usecases.CreateUserUseCase;
import com.rifas.trevorifas.application.ports.in.users.CreateUserUseCasePort;
import com.rifas.trevorifas.application.ports.out.profiles.FindProfileAdapterPort;
import com.rifas.trevorifas.application.ports.out.users.CreateUserAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {

  @Bean
  public CreateUserUseCasePort createUserUseCasePort(CreateUserAdapterPort createUserAdapterPort,
      FindProfileAdapterPort findProfileAdapterPort, PasswordEncoder encoder) {
    return new CreateUserUseCase(createUserAdapterPort, findProfileAdapterPort, encoder);
  }
}
