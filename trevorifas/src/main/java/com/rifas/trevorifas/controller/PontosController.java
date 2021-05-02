package com.rifas.trevorifas.controller;


import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.service.PontosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ponto")
@RequiredArgsConstructor
public class PontosController {

    private final PontosService pontosService;

    @GetMapping("{idRifa}")
    @ResponseStatus(HttpStatus.OK)
    public PontoResponseDTO listaPontos(@PathVariable Long idRifa) {
        return pontosService.listaPontos(idRifa);
    }
}
