package com.rifas.trevorifas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.ProfileEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.domain.enums.EnumPerfil;
import com.rifas.trevorifas.adapters.outbound.repositories.profiles.ProfileRepository;
import com.rifas.trevorifas.adapters.outbound.repositories.users.UserRepository;
import com.rifas.trevorifas.exception.SenhaInvalidaException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UserDetailsService {

	private final PasswordEncoder encoder;

	private final UserRepository repository;

	private final ProfileRepository profileRepository;

	public UserDetails autenticar(UserEntity userEntity) {
		UserDetails userDetails = loadUserByUsername(userEntity.getEmail());
		boolean isSenha = encoder.matches(userEntity.getSenha(), userDetails.getPassword());
		if (isSenha) {
			return userDetails;
		}
		throw new SenhaInvalidaException();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		List<String> listaRoles = new ArrayList<>();
	
		userEntity.getProfiles().forEach(role -> listaRoles.add(role.getNome()));
		String[] roles = listaRoles.stream().toArray(n -> new String[n]);
		
		return User.builder().username(userEntity.getEmail()).password(userEntity.getSenha()).roles(roles).build();
	}
	


}
