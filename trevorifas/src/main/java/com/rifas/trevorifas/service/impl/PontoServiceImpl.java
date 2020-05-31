package com.rifas.trevorifas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rifas.trevorifas.EnumRifa;
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
	public List<Ponto> listaPontoPorIdRifa(Long idRifa) {

		List<Ponto> list = pontoRepository.findAll();

		Rifa rifa = rifaRepository.findById(idRifa).get();
		
		List<Ponto> pontos = filtraPontosPorRifa(list,rifa);
		
		List<UsuarioRifaPonto> urpList = usuarioRifaPontoRepository.findByRifa(rifa);
		
		return pontos;
	}

	private List<Ponto> filtraPontosPorRifa(List<Ponto> listaPostos, Rifa rifa) {
 
		List<Ponto> result = null;
		if (rifa.getTipoRifa().equals(EnumRifa.RIFA)) {
			result = listaPostos.stream().filter(p -> p.getRifas() != null).collect(Collectors.toList());
		}
		return result;

	}

}
