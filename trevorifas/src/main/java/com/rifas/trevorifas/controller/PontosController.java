package com.rifas.trevorifas.controller;


import com.rifas.trevorifas.config.FileStorageConfig;
import com.rifas.trevorifas.controller.dto.PontoDTO;
import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.service.ListaPontosService;
import com.rifas.trevorifas.service.PontoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ponto")
@RequiredArgsConstructor
public class PontosController {

    private final ListaPontosService listarPontosService;

    private final PontoService pontoService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Ponto criar(@RequestBody PontoDTO dto) {
        return pontoService.salvar(dto);
    }

    @GetMapping("{idRifa}")
    @ResponseStatus(HttpStatus.OK)
    public List<PontoResponseDTO> listaPontos(@PathVariable Long idRifa) {
        return listarPontosService.listaPontos(idRifa);
    }
}
