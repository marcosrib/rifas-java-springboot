package com.rifas.trevorifas.adapters.outbound.repositories.users;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.application.ports.out.CreateUserAdapterPort;
import com.rifas.trevorifas.domain.entity.Perfil;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class CreateUserAdapter implements CreateUserAdapterPort {
  private final UserRepository userRepository;

  public CreateUserAdapter(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User create(User user) {
    Set<Perfil> perfisSet = new HashSet<>();

    user.getProfiles().forEach(p -> {
      Perfil profile = new  Perfil();
      profile.setNome(p.getNome());
      perfisSet.add(profile);
    } );
    perfisSet.addAll(user.getProfiles());
    UserEntity userEntity =  UserEntity
        .builder()
        .nome(user.getName())
        .email(user.getEmail())
        .senha(user.getPassword())
        .build();

    return User.convertUserEntitytoUser(userRepository.save(userEntity));
  }
}
