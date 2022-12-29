package com.rifas.trevorifas.adapters.inbound.controllers;


import com.rifas.trevorifas.adapters.inbound.controllers.request.PointRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.FindPointResponse;
import com.rifas.trevorifas.adapters.inbound.controllers.response.PointResponse;
import com.rifas.trevorifas.adapters.inbound.controllers.swagger.api.PointApi;
import com.rifas.trevorifas.application.ports.in.points.FindPointUseCasePort;
import com.rifas.trevorifas.application.ports.in.points.CreatePointUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/point")
@RequiredArgsConstructor
public class PointController implements PointApi {

    private final FindPointUseCasePort findPointUseCasePort;

    private final CreatePointUseCasePort createPointUseCasePort;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PointResponse create(@RequestBody PointRequest pointRequest) {
        return PointResponse.fromDomain(createPointUseCasePort.create(pointRequest.toPointDomain()));
    }

    @GetMapping("{raffleId}")
    @ResponseStatus(HttpStatus.OK)
    public List<FindPointResponse> findPoint(@PathVariable Long raffleId) {
        return FindPointResponse.convertListPointDomainToLisResponse(findPointUseCasePort.findPointsByIdRaffle(raffleId));
    }
}
