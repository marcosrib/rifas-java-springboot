package com.rifas.trevorifas.adapters.inbound.controllers;

import com.rifas.trevorifas.adapters.inbound.controllers.request.RaffleRequest;
import com.rifas.trevorifas.adapters.inbound.controllers.response.RaffleResponse;
import com.rifas.trevorifas.adapters.inbound.controllers.swagger.api.RaffleApi;
import com.rifas.trevorifas.application.core.domain.Raffle;
import com.rifas.trevorifas.application.ports.in.raffles.CreateRaffleUseCasePort;
import com.rifas.trevorifas.service.files.service.FileStorageService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.trevorifas.controller.dto.RifaDTO;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import com.rifas.trevorifas.service.RifaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/raffle")
@RequiredArgsConstructor
public class RaffleController  implements RaffleApi {

    private final RifaService service;
    private final CreateRaffleUseCasePort createRaffleUseCasePort;

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public RaffleResponse create(@RequestBody RaffleRequest raffleRequest) {
        return RaffleResponse.fromDomain(createRaffleUseCasePort.create(raffleRequest.toRaffleDomain()));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<RaffleEntity> getAllRaffle(@RequestParam Integer page) {
        return service.listaRifas(page);
    }
}
