package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.domain.entity.Perfil;
import java.util.Set;

public class User {

  private Integer id;
  private String name;
  private String email;
  private String password;
  private Set<Perfil> profiles;

  public User(String name) {
  }

  public User(String name, String email, String password, Set<Perfil> profiles) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.profiles = profiles;
  }

  public User(Integer id, String name, String email, String password, Set<Perfil> profiles) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.profiles = profiles;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Perfil> getProfiles() {
    return profiles;
  }

  public void setProfiles(Set<Perfil> profiles) {
    this.profiles = profiles;
  }

  public static User convertUserEntitytoUser(UserEntity userEntity) {
   return  new User(userEntity.getId(), userEntity.getNome(), userEntity.getEmail(), userEntity.getSenha(), userEntity.getPerfis());
  }
}
