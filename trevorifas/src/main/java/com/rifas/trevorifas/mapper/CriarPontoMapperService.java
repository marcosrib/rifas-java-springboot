package com.rifas.trevorifas.mapper;

import com.rifas.trevorifas.adapters.inbound.controllers.request.PointRequest;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import org.springframework.stereotype.Service;

@Service
public interface CriarPontoMapperService {
    PointEntity convertePontoDTOParaPontoEntity(PointRequest dto);
}
