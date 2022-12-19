package com.rifas.trevorifas.config;

import com.rifas.trevorifas.application.core.usecases.CreateUserUseCase;
import com.rifas.trevorifas.application.ports.in.CreateUserUseCasePort;
import com.rifas.trevorifas.application.ports.out.CreateUserAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {

  @Bean
  public CreateUserUseCasePort createUserUseCasePort(CreateUserAdapterPort createUserAdapterPort, PasswordEncoder encoder) {
    return new CreateUserUseCase(createUserAdapterPort, encoder);
  }
}
