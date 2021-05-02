package com.rifas.trevorifas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.domain.entity.PontoUsuarioRifa;

public interface PontoRifaRepository extends JpaRepository<PontoUsuarioRifa, Long>{

  List<PontoUsuarioRifa> findByIdRifa(Long rifa);
  
}
