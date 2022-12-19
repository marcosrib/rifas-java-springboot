package com.rifas.trevorifas.adapters.outbound.repositories.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByEmail(String email);
}
