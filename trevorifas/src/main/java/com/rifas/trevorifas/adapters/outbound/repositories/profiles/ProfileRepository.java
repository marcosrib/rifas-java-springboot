package com.rifas.trevorifas.adapters.outbound.repositories.profiles;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifas.trevorifas.domain.entity.Perfil;


public interface ProfileRepository extends JpaRepository<Perfil, Integer> {
	
  Set<Perfil> findByNomeIn(List<String> profile);
}
