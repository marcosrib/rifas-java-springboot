package com.rifas.trevorifas.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rifas.trevorifas.domain.entity.Perfil;
import com.rifas.trevorifas.domain.entity.Usuario;
import com.rifas.trevorifas.domain.repository.PerfilRepository;
import com.rifas.trevorifas.domain.repository.UsuarioRepository;
import com.rifas.trevorifas.exception.SenhaInvalidaException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UserDetailsService {

	private final PasswordEncoder encoder;

	private final UsuarioRepository repository;

	private final PerfilRepository perfilRepository;

	public UserDetails autenticar(Usuario usuario) {
		UserDetails userDetails = loadUserByUsername(usuario.getEmail());
		boolean isSenha = encoder.matches(usuario.getSenha(), userDetails.getPassword());
		if (isSenha) {
			return userDetails;
		}
		throw new SenhaInvalidaException();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		List<String> listaRoles = new ArrayList<>();
	
		usuario.getPerfis().forEach(role -> listaRoles.add(role.getNome()));
		String[] roles = listaRoles.stream().toArray(n -> new String[n]);
		
		return User.builder().username(usuario.getEmail()).password(usuario.getSenha()).roles(roles).build();
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {
		List<String> listaNomePerfil = new ArrayList<String>();
		usuario.getPerfis().forEach(perfil -> {
			listaNomePerfil.add(perfil.getNome());
		});

		Set<Perfil> perfis = perfilRepository.findByNomeIn(listaNomePerfil);
		Usuario usuarioFinal = Usuario.builder().email(usuario.getEmail()).nome(usuario.getNome())
				.senha(usuario.getSenha()).perfis(perfis).build();
		return repository.save(usuarioFinal);
	}
	
	@Transactional
	public Usuario editar(Usuario usuario) {
	    Usuario usuarioFinal = repository.findById(usuario.getId())
	    		                   .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
	    usuarioFinal.setEmail(usuario.getEmail());
	    usuarioFinal.setNome(usuario.getNome());
	    
	    if(!StringUtils.isEmpty(usuario.getSenha())) {
	    	String senhaCriptografada = encoder.encode(usuario.getSenha());
	    	usuarioFinal.setSenha(senhaCriptografada);
	    }
	    
	    List<String> listaNomePerfil = new ArrayList<String>();
		usuario.getPerfis().forEach(perfil -> {
			listaNomePerfil.add(perfil.getNome());
		});

		Set<Perfil> perfis = perfilRepository.findByNomeIn(listaNomePerfil);
	
	    usuarioFinal.setPerfis(perfis);
	    
		return repository.save(usuarioFinal);
	}

}
