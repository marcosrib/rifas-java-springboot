package com.rifas.trevorifas.mapper;

import com.rifas.trevorifas.controller.dto.PontoDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import org.springframework.stereotype.Service;

@Service
public interface CriarPontoMapperService {
    Ponto convertePontoDTOParaPontoEntity(PontoDTO dto);
}
