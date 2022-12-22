package com.rifas.trevorifas.adapters.outbound.repositories.users;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.application.ports.out.users.CreateUserAdapterPort;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.ProfileEntity;
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
    Set<ProfileEntity> profiles = new HashSet<>();
    user.getProfiles().forEach(p -> {
      ProfileEntity profileEntity = new ProfileEntity();
      profileEntity.setId(p.getId());
      profileEntity.setNome(p.getName());
      profiles.add(profileEntity);
    });

    UserEntity userEntity = UserEntity
        .builder()
        .nome(user.getName())
        .email(user.getEmail())
        .senha(user.getPassword())
        .profiles(profiles)
        .build();
     UserEntity resUserEntity =  userRepository.save(userEntity);
    return User.convertUserEntitytoUser(resUserEntity);
  }
}
