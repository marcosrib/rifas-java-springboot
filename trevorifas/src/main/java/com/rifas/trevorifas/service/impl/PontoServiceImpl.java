package com.rifas.trevorifas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.EnumRifa;
import com.rifas.trevorifas.controller.dto.ResponsePontosDTO;
import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.domain.entity.UsuarioRifaPonto;
import com.rifas.trevorifas.domain.repository.PontoRepository;
import com.rifas.trevorifas.domain.repository.RifaRepository;
import com.rifas.trevorifas.domain.repository.UsuarioRifaPontoRepository;
import com.rifas.trevorifas.service.PontoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PontoServiceImpl implements PontoService {

	private final PontoRepository pontoRepository;

	private final RifaRepository rifaRepository;

	private final UsuarioRifaPontoRepository usuarioRifaPontoRepository;

	@Override
	public List<ResponsePontosDTO> listaPontoPorIdRifa(Long idRifa) {

		List<ResponsePontosDTO> listaResponse = new ArrayList<>();

		List<Ponto> listaPontos = pontoRepository.findAll();

		Rifa rifa = rifaRepository.findById(idRifa).get();

		List<ResponsePontosDTO> pontos = filtraPontosPorRifa(listaPontos, rifa);

		List<UsuarioRifaPonto> urpLista = usuarioRifaPontoRepository.findByRifa(rifa);

		if (urpLista.isEmpty()) {
			return pontos;
		}

		pontos.forEach(p -> {

			UsuarioRifaPonto resultado = urpLista.stream()
					.filter(filter -> filter.getPonto().getId().equals(p.getIdPonto())).findAny().orElse(null);
		
			if (resultado != null) {
				listaResponse.add(new ResponsePontosDTO(p.getIdPonto(), p.getPontos(),
						resultado.getUsuario().getId().toString(), resultado.getValor().toString()));
			} else {
				listaResponse.add(new ResponsePontosDTO(p.getIdPonto(), p.getPontos(), null, null));
			}

		});

		return listaResponse;
	}

	private List<ResponsePontosDTO> filtraPontosPorRifa(List<Ponto> listaPostos, Rifa rifa) {

		List<Ponto> result = new ArrayList<>();
		List<ResponsePontosDTO> listaPontosReponse = new ArrayList<>();

		if (rifa.getTipoRifa().equals(EnumRifa.RIFA)) {
			result = listaPostos.stream().filter(p -> p.getRifas() != null).collect(Collectors.toList());
			result.forEach(p -> {
				listaPontosReponse.add(new ResponsePontosDTO(p.getId(), p.getRifas(), null, null));
			});
		}
		return listaPontosReponse;

	}

}
