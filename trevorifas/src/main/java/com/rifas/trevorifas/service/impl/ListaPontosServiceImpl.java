package com.rifas.trevorifas.service.impl;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.domain.repository.PontoRepository;
import com.rifas.trevorifas.domain.repository.RifaRepository;
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

    private  final RifaRepository rifaRepository;

    private final PontoRepository  pontoRepository;

    @Override
    public  List<PontoResponseDTO>  listaPontos(Long idRifa) {
        Optional<Rifa> rifa = rifaRepository.findById(idRifa);
        List<Ponto> recuperaPontos = pontoRepository.findAllByRifa(rifa.get());
        if(!rifa.isPresent()) {
            throw new RegraNegocioException("Rifa não encontrada");
        }
        IntStream streamRangePontos = IntStream.range(0,rifa.get().getQuantidadePonto());

        List<PontoResponseDTO> pontos =  streamRangePontos.mapToObj(ponto -> {
            Optional<Ponto> pontoFiltrado = verificarListaDePontosEstaVaziaEFiltrarPorIdPontos(recuperaPontos, ponto);
            if(pontoFiltrado.isPresent()) {
                return new PontoResponseDTO(pontoFiltrado.get().getId(), String.valueOf(ponto) , pontoFiltrado.get().getUserEntity().getId(), null, pontoFiltrado.get().isPontoEscolhido());
            }
            return new PontoResponseDTO(null, String.valueOf(ponto) , null, null, false);
        }).collect(Collectors.toList());

        return pontos;
    }

    private Optional<Ponto> verificarListaDePontosEstaVaziaEFiltrarPorIdPontos(List<Ponto> lista, int ponto ) {
             return  lista.stream().filter(p -> p.getPonto().equals(adicionaZeroNaAEquerdaNumeroMenorQueDez(ponto))).findAny();
    }

    private String adicionaZeroNaAEquerdaNumeroMenorQueDez(int numero) {
        return (numero < 10) ? "0" + numero : String.valueOf(numero);
    }
}
