
package com.rifas.trevorifas.mapper.impl;

import com.rifas.trevorifas.controller.dto.PontoDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.mapper.CriarPontoMapperService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class CriarPontoMapperServiceImpl implements CriarPontoMapperService {

    @Override
    public Ponto convertePontoDTOParaPontoEntity(PontoDTO dto) {
        return Ponto.builder()
                .ponto(dto.getPonto())
                .rifa(Rifa.builder().id(dto.getIdRifa()).build())
                .userEntity(UserEntity.builder().id(dto.getIdUsuario()).build())
                .valor(new BigDecimal(dto.getValor()))
                .pontoEscolhido(true)
                .build();
    }
}
