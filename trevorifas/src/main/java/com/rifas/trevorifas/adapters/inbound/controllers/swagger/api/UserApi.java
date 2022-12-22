package com.rifas.trevorifas.adapters.inbound.controllers.swagger.api;

import com.rifas.trevorifas.adapters.inbound.controllers.request.UserRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User Api")
public interface UserApi {
  @Operation(summary = "Cadastra um novo usuário")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Usuário criao com sucesso."),
      @ApiResponse(responseCode = "422", description = "Dados Invalidos.")
  })
  UserResponse create(@RequestBody UserRequest userRequest);
}
