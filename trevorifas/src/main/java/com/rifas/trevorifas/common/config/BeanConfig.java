package com.rifas.trevorifas.common.config;

import com.rifas.trevorifas.application.core.usecases.AuthUseCase;
import com.rifas.trevorifas.application.core.usecases.CreateImageUseCase;
import com.rifas.trevorifas.application.core.usecases.CreatePointUseCase;
import com.rifas.trevorifas.application.core.usecases.CreateRaffleUseCase;
import com.rifas.trevorifas.application.core.usecases.CreateUserUseCase;
import com.rifas.trevorifas.application.core.usecases.FindPointUseCase;
import com.rifas.trevorifas.application.ports.in.auth.AuthUseCasePort;
import com.rifas.trevorifas.application.ports.in.images.CreateImageUseCasePort;
import com.rifas.trevorifas.application.ports.in.points.CreatePointUseCasePort;
import com.rifas.trevorifas.application.ports.in.points.FindPointUseCasePort;
import com.rifas.trevorifas.application.ports.in.raffles.CreateRaffleUseCasePort;
import com.rifas.trevorifas.application.ports.in.users.CreateUserUseCasePort;
import com.rifas.trevorifas.application.ports.out.auth.AuthAdapterPort;
import com.rifas.trevorifas.application.ports.out.file.CreateFileAdapterPort;
import com.rifas.trevorifas.application.ports.out.fileStorage.FileAdapterPort;
import com.rifas.trevorifas.application.ports.out.points.CreatePointAdapterPort;
import com.rifas.trevorifas.application.ports.out.points.FindPointByRaffleIdAdapterPort;
import com.rifas.trevorifas.application.ports.out.profiles.FindProfileAdapterPort;
import com.rifas.trevorifas.application.ports.out.raffles.CreateRaffleAdapterPort;
import com.rifas.trevorifas.application.ports.out.raffles.FindRaffleByIdAdapterPort;
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

  @Bean
  public AuthUseCasePort authUseCasePort(AuthAdapterPort authAdapterPort) {
    return new AuthUseCase(authAdapterPort);
  }

  @Bean
  public CreatePointUseCasePort createPointUseCasePort(
      CreatePointAdapterPort createPointAdapterPort) {
    return new CreatePointUseCase(createPointAdapterPort);
  }

  @Bean
  public CreateRaffleUseCasePort createRaffleUseCasePort(
      CreateRaffleAdapterPort createRaffleAdapterPort) {
    return new CreateRaffleUseCase(createRaffleAdapterPort);
  }

  @Bean
  public FindPointUseCasePort findPointUseCasePort(
      FindPointByRaffleIdAdapterPort findPointByRaffleIdAdapterPor,
      FindRaffleByIdAdapterPort findRaffleByIdAdapterPort) {
    return new FindPointUseCase(findPointByRaffleIdAdapterPor, findRaffleByIdAdapterPort);
  }

  @Bean
  public CreateImageUseCasePort createImageUseCasePort(
          FileAdapterPort saveFileLocalAdapterPort, CreateFileAdapterPort createFileAdapterPort) {
    return new CreateImageUseCase(saveFileLocalAdapterPort, createFileAdapterPort);
  }


}
