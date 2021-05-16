package com.rifas.trevorifas.service;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListaPontosService {
    List<PontoResponseDTO> listaPontos(Long idRifa);
}
