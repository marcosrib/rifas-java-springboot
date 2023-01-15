package com.rifas.trevorifas.adapters.inbound.controllers.swagger.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "File Api")
public interface FileApi {

  @Operation(summary = "Cadastrar um Imagem")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "File criado com sucesso."),
  })
  void save(@RequestParam Long raffleId, @RequestPart MultipartFile file) throws IOException;
}
