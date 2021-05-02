package com.rifas.trevorifas.service;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface PontosService {
    PontoResponseDTO listaPontos(Long idRifa);
}
