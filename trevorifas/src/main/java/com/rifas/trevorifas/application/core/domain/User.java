package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class User {

  private Long id;
  private String name;
  private String email;
  private String userName;
  private String password;
  private Set<Profile> profiles;

  public User() {
  }

  public User(String name, String email, String password, Set<Profile> profiles, String userName) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.profiles = profiles;
    this.userName = userName;
  }

  public User(Long id, String name, String email, String password, String userName, Set<Profile> profiles) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.userName = userName;
    this.profiles = profiles;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public static User convertUserEntitytoUser(UserEntity userEntity) {
    Set<Profile> profiles = userEntity.getProfiles().stream()
        .map(profileEntity -> new Profile(profileEntity.getId(), profileEntity.getName())).collect(
            Collectors.toSet());
    return new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(),
        userEntity.getPassword(), userEntity.getUsername(), profiles);
  }
}
