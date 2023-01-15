package com.rifas.trevorifas.adapters.outbound.repositories.profiles;

import com.rifas.trevorifas.application.core.domain.enums.EnumProfile;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.ProfileEntity;


public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {
	
  Set<ProfileEntity> findByNameIn(List<EnumProfile> profile);
}
