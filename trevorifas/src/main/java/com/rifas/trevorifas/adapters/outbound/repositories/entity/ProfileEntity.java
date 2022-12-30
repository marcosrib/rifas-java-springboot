package com.rifas.trevorifas.adapters.outbound.repositories.entity;

import com.rifas.trevorifas.application.core.domain.enums.EnumProfile;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "profiles")
public class ProfileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 30, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private EnumProfile name;
	
	@ManyToMany(mappedBy = "profiles")
	@JsonIgnore
	private Set<UserEntity> userEntities;
	
}
