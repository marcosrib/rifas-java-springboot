package com.rifas.trevorifas.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rifas.trevorifas.domain.entity.Perfil;
import com.rifas.trevorifas.domain.entity.Usuario;
import com.rifas.trevorifas.domain.repository.PerfilRepository;
import com.rifas.trevorifas.domain.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UserDetailsService {

	private final PasswordEncoder encoder;

	private final UsuarioRepository repository;

	private final PerfilRepository perfilRepository;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Usuario usuario = repository.findByNome(nome)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		String[] roles = new String[] { "ADMIN", "USER" };
		return User.builder().username(usuario.getEmail()).password(encoder.encode(usuario.getSenha())).roles(roles)
				.build();
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {
        List<String> listaNomePerfil = new  ArrayList<String>();
	    usuario.getPerfis().forEach(perfil -> {
	    	listaNomePerfil.add(perfil.getNome());
	    });
		
		Set<Perfil> perfis = perfilRepository.findByNomeIn(listaNomePerfil);
		Usuario usuarioFinal = Usuario.builder().email(usuario.getEmail()).nome(usuario.getNome())
				.senha(usuario.getSenha()).perfis(perfis).build();
		return repository.save(usuarioFinal);
	}

}
