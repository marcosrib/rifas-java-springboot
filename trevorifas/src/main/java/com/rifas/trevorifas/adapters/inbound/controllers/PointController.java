package com.rifas.trevorifas.adapters.inbound.controllers;


import com.rifas.trevorifas.adapters.inbound.controllers.request.PointRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.PointResponse;
import com.rifas.trevorifas.adapters.inbound.controllers.swagger.api.PointApi;
import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import com.rifas.trevorifas.service.ListaPontosService;
import com.rifas.trevorifas.application.ports.in.points.CreatePointUseCasePort;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/point")
@RequiredArgsConstructor
public class PointController implements PointApi {

    private final ListaPontosService listarPontosService;

    private final CreatePointUseCasePort createPointUseCasePort;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PointResponse create(@RequestBody PointRequest pointRequest) {
        return PointResponse.fromDomain(createPointUseCasePort.create(pointRequest.toPointDomain()));
    }

    @GetMapping("{idRifa}")
    @ResponseStatus(HttpStatus.OK)
    public List<PontoResponseDTO> listaPontos(@PathVariable Long idRifa) {
        return listarPontosService.listaPontos(idRifa);
    }
}
