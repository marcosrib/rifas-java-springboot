package com.rifas.trevorifas.application.core.domain;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.ProfileEntity;
import com.rifas.trevorifas.application.core.domain.enums.EnumProfile;
import java.util.Set;
import java.util.stream.Collectors;


public class Profile {

  private Integer id;
  private EnumProfile name;

  public Profile() {
  }

  public Profile(Integer id, EnumProfile name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EnumProfile getName() {
    return name;
  }

  public void setName(EnumProfile name) {
    this.name = name;
  }

  public static Set<Profile> convertProfileEntityToProfile(Set<ProfileEntity> profilesEntity) {
    return profilesEntity.stream()
        .map(profile -> new Profile(profile.getId(), profile.getName()))
        .collect(Collectors.toSet());
  }
}
