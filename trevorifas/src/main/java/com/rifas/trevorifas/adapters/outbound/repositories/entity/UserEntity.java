package com.rifas.trevorifas.adapters.outbound.repositories.entity;

import com.rifas.trevorifas.domain.entity.Rifa;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "senha", nullable = false)
	private String senha;

	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private Set<Rifa> rifas;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private Set<ProfileEntity> profiles;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;

	@PrePersist
	public void prePersist() {
		dataCriacao = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		dataCriacao = LocalDateTime.now();
	}
}
