package com.rifas.trevorifas.adapters.inbound.controllers.swagger.api;

import com.rifas.trevorifas.adapters.inbound.controllers.request.PointRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.PointResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Point Api")
public interface PointApi {
  @Operation(summary = "Cadastra pontos")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Pontos cadastrado com sucesso."),
      @ApiResponse(responseCode = "422", description = "Dados Invalidos.")
  })
  PointResponse create(@RequestBody PointRequest request);
}
