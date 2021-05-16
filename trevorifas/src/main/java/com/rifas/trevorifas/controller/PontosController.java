package com.rifas.trevorifas.controller;


import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.service.ListaPontosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ponto")
@RequiredArgsConstructor
public class PontosController {

    private final ListaPontosService pontosService;

    @GetMapping("{idRifa}")
    @ResponseStatus(HttpStatus.OK)
    public List<PontoResponseDTO> listaPontos(@PathVariable Long idRifa) {
        return pontosService.listaPontos(idRifa);
    }
}
