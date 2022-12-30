package com.rifas.trevorifas.common.config;

import com.rifas.trevorifas.adapters.outbound.repositories.auth.AuthAdapter;
import com.rifas.trevorifas.application.ports.out.auth.AuthAdapterPort;
import com.rifas.trevorifas.security.jwt.JwtAuthFilter;
import com.rifas.trevorifas.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthAdapter authAdapterPort;

  @Autowired
  private JwtService jwtService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public OncePerRequestFilter jwtFilter() {
    return new JwtAuthFilter(jwtService, authAdapterPort);

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(authAdapterPort).passwordEncoder(passwordEncoder());
  }

  private static final String[] AUTH_WHITE_LIST = {
      "/v3/api-docs/**",
      "/swagger-ui/**",
      "/v2/api-docs/**",
      "/swagger-resources/**"
  };

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers(AUTH_WHITE_LIST)
        .permitAll()
        .antMatchers("/api/auth/**")
        .permitAll()
        .antMatchers("/api/raffle/**").permitAll()
        .antMatchers("/api/point/**").permitAll()
     //   .hasAnyRole("ADMIN", "USER")
        .antMatchers(HttpMethod.POST, "/api/usuario/**")
        .permitAll()
        .antMatchers("/api/imagem/**")
        .permitAll()
        .antMatchers("/ws**")
        .permitAll()
        .anyRequest().authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
  }

}

