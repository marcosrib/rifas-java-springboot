package com.rifas.trevorifas.domain.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifas.trevorifas.domain.entity.Perfil;


public interface PerfilRepository  extends JpaRepository<Perfil, Integer> {
	
  Set<Perfil> findByNomeIn(List<String> perfil);
}
