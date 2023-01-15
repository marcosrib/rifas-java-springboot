package com.rifas.trevorifas.adapters.outbound.repositories.profiles;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.ProfileEntity;
import com.rifas.trevorifas.application.core.domain.Profile;
import com.rifas.trevorifas.application.core.domain.enums.EnumProfile;
import com.rifas.trevorifas.application.ports.out.profiles.FindProfileAdapterPort;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class findProfileByNameInAdapter implements FindProfileAdapterPort {
private final ProfileRepository profileRepository;

  public findProfileByNameInAdapter(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }


  @Override
  public Set<Profile> findProfileByNameIn(List<EnumProfile> profiles) {
   Set<ProfileEntity> profileEntities =  profileRepository.findByNameIn(profiles);
    return Profile.convertProfileEntityToProfile(profileEntities);
  }
}
