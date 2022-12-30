package com.rifas.trevorifas.adapters.outbound.repositories.auth;


import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.users.UserRepository;
import com.rifas.trevorifas.application.core.domain.Auth;
import com.rifas.trevorifas.application.core.domain.User;
import com.rifas.trevorifas.application.ports.out.auth.AuthAdapterPort;
import com.rifas.trevorifas.application.ports.out.users.FindUserAdapterPort;


import com.rifas.trevorifas.security.jwt.JwtService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthAdapter implements AuthAdapterPort, UserDetailsService {

  private final FindUserAdapterPort findUserAdapterPort;
  private final PasswordEncoder encoder;

  private final UserRepository userRepository;
  private final JwtService jwtservice;
  public AuthAdapter(FindUserAdapterPort findUserAdapterPort, PasswordEncoder encoder,
      UserRepository userRepository,
      JwtService jwtservice) {
    this.findUserAdapterPort = findUserAdapterPort;
    this.encoder = encoder;
    this.userRepository = userRepository;
    this.jwtservice = jwtservice;
  }

  @Override
  public String authenticate(Auth auth) {
    UserDetails userDetails = loadUserByUsername(auth.getEmail());
    boolean isPasswordMatch = encoder.matches(auth.getPassword(), userDetails.getPassword());
   if(isPasswordMatch) {
     return jwtservice.gerarToken(auth);
   }
   return null;
  }


  public UserDetails loadUserByUsername(String email) {
    UserEntity userEntity = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    List<String> listRoles = new ArrayList<>();

    userEntity.getProfiles().forEach(role -> listRoles.add(role.getName().toString()));
    String[] roles = listRoles.stream().toArray(n -> new String[n]);

    return org.springframework.security.core.userdetails.User.builder()
        .username(userEntity.getEmail()).password(userEntity.getPassword()).roles(roles).build();
  }
}
