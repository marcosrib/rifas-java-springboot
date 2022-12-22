package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.ProfileEntity;
import java.util.Set;
import java.util.stream.Collectors;


public class Profile {

  private Integer id;
  private String name;

  public Profile() {
  }

  public Profile(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static Set<Profile> convertProfileEntityToProfile(Set<ProfileEntity> profilesEntity) {
    return profilesEntity.stream()
        .map(profile -> new Profile(profile.getId(), profile.getNome()))
        .collect(Collectors.toSet());
  }
}
