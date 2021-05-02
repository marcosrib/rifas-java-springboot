package com.rifas.trevorifas.service.impl;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.domain.entity.PontoUsuarioRifa;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.domain.repository.RifaRepository;
import com.rifas.trevorifas.exception.RegraNegocioException;
import com.rifas.trevorifas.service.PontoUsuarioRifaService;
import com.rifas.trevorifas.service.PontosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PontosServiceImpl implements PontosService {

    private  final RifaRepository rifaRepository;

    private final PontoUsuarioRifaService pontoUsuarioRifaService;

    @Override
    public PontoResponseDTO listaPontos(Long idRifa) {
        Optional<Rifa> rifa = rifaRepository.findById(idRifa);
        List<PontoUsuarioRifa> pontoUsuarioRifas = pontoUsuarioRifaService.buscarPontoUsuarioRifaPorIdRifa(idRifa);
        if(!rifa.isPresent()) {
            throw new RegraNegocioException("Rifa não encontrada");
        }

        IntStream streamRangePontos = IntStream.range(0,rifa.get().getQuantidadePonto());

        List<PontoResponseDTO> pontos =  streamRangePontos.mapToObj(ponto -> new PontoResponseDTO(null, String.valueOf(ponto + 1)  , null, null, null))
                .collect(Collectors.toList());
        /*pontos.stream().map(pontoRifa ->
                new PontoResponseDTO(null, pontoRifa.getPontos()  , null, null, ))
                .collect(Collectors.toList());*/

        System.out.println(pontos);
        return null;
    }
}
