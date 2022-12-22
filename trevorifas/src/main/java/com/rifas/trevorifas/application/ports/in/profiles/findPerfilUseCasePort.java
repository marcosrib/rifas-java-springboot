package com.rifas.trevorifas.application.ports.in.profiles;

import com.rifas.trevorifas.application.core.domain.Profile;
import java.util.List;
import java.util.Set;

public interface findPerfilUseCasePort {
  Set<Profile> findProfileByNameIn(List<Profile> profiles);
}
