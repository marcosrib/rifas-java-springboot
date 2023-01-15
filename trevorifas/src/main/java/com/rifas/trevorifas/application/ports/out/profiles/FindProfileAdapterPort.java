package com.rifas.trevorifas.application.ports.out.profiles;

import com.rifas.trevorifas.application.core.domain.Profile;
import com.rifas.trevorifas.application.core.domain.enums.EnumProfile;
import java.util.List;
import java.util.Set;

public interface FindProfileAdapterPort {
  Set<Profile>  findProfileByNameIn(List<EnumProfile> profiles);
}
