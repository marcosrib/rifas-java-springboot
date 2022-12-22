package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class User {

  private Integer id;
  private String name;
  private String email;
  private String password;
  private Set<Profile> profiles;

  public User() {
  }

  public User(String name, String email, String password, Set<Profile> profiles) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.profiles = profiles;
  }

  public User(Integer id, String name, String email, String password, Set<Profile> profiles) {
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

  public Set<Profile> getProfiles() {
    return profiles;
  }

  public void setProfiles(Set<Profile> profiles) {
    this.profiles = profiles;
  }

  public static User convertUserEntitytoUser(UserEntity userEntity) {
    Set<Profile> profiles = userEntity.getProfiles().stream()
        .map(profileEntity -> new Profile(profileEntity.getId(), profileEntity.getNome())).collect(
            Collectors.toSet());
    return new User(userEntity.getId(), userEntity.getNome(), userEntity.getEmail(),
        userEntity.getSenha(), profiles);
  }
}
