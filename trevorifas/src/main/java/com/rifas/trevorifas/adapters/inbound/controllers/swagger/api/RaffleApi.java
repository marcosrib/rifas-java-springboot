package com.rifas.trevorifas.adapters.inbound.controllers.swagger.api;

import com.rifas.trevorifas.adapters.inbound.controllers.request.RaffleRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.RaffleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
@Tag(name = "Rifa Api")
public interface RaffleApi {
  @Operation(summary = "Cadastra uma nova rifa")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Usuário criao com sucesso."),
      @ApiResponse(responseCode = "422", description = "Dados Invalidos.")
  })
  RaffleResponse create(@RequestBody RaffleRequest raffleRequest);
}
