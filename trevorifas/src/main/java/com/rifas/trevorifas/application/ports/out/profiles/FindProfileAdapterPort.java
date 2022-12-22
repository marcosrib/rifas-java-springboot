package com.rifas.trevorifas.application.ports.out.profiles;

import com.rifas.trevorifas.application.core.domain.Profile;
import java.util.List;
import java.util.Set;

public interface FindProfileAdapterPort {
  Set<Profile>  findProfileByNameIn(List<String> profiles);
}
