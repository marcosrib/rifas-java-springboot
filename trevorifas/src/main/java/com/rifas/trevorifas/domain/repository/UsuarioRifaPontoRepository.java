package com.rifas.trevorifas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.domain.entity.UsuarioRifaPonto;

public interface UsuarioRifaPontoRepository extends JpaRepository<UsuarioRifaPonto, Long>{

  List<UsuarioRifaPonto> findByRifa(Rifa rifa);	
  
}
