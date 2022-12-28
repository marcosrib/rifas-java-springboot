package com.rifas.trevorifas.service.impl;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.points.PointRepository;
import com.rifas.trevorifas.adapters.outbound.repositories.Raffles.RaffleRepository;
import com.rifas.trevorifas.exception.RegraNegocioException;
import com.rifas.trevorifas.service.ListaPontosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ListaPontosServiceImpl implements ListaPontosService {

    private  final RaffleRepository rifaRepository;

    private final PointRepository pontoRepository;

    @Override
    public  List<PontoResponseDTO>  listaPontos(Long idRifa) {
        Optional<RaffleEntity> rifa = rifaRepository.findById(idRifa);
        List<PointEntity> recuperaPontos = pontoRepository.findAllByRaffle(rifa.get());
        if(!rifa.isPresent()) {
            throw new RegraNegocioException("Rifa não encontrada");
        }
        IntStream streamRangePontos = IntStream.range(0,rifa.get().getPointQuantity());

        List<PontoResponseDTO> pontos =  streamRangePontos.mapToObj(ponto -> {
            Optional<PointEntity> pontoFiltrado = verificarListaDePontosEstaVaziaEFiltrarPorIdPontos(recuperaPontos, ponto);
            if(pontoFiltrado.isPresent()) {
                return new PontoResponseDTO(pontoFiltrado.get().getId(), String.valueOf(ponto) , pontoFiltrado.get().getUser().getId(), null, pontoFiltrado.get().isPointSelected());
            }
            return new PontoResponseDTO(null, String.valueOf(ponto) , null, null, false);
        }).collect(Collectors.toList());

        return pontos;
    }

    private Optional<PointEntity> verificarListaDePontosEstaVaziaEFiltrarPorIdPontos(List<PointEntity> lista, int ponto ) {
             return  lista.stream().filter(p -> p.getPoint().equals(adicionaZeroNaAEquerdaNumeroMenorQueDez(ponto))).findAny();
    }

    private String adicionaZeroNaAEquerdaNumeroMenorQueDez(int numero) {
        return (numero < 10) ? "0" + numero : String.valueOf(numero);
    }
}
