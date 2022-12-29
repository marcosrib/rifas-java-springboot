package com.rifas.trevorifas.security.jwt;

import com.rifas.trevorifas.application.ports.out.auth.AuthAdapterPort;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthFilter extends OncePerRequestFilter {

  private JwtService jwtService;
  private AuthAdapterPort authAdapterPort;

  public JwtAuthFilter(JwtService jwtService, AuthAdapterPort authAdapterPort) {
    this.jwtService = jwtService;
    this.authAdapterPort = authAdapterPort;
  }


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain)
      throws ServletException, IOException {

    String authorization = request.getHeader("Authorization");

    if (authorization != null && authorization.startsWith("Bearer")) {
      String token = authorization.split(" ")[1];
      boolean isValid = jwtService.tokenValido(token);
      if (isValid) {
        String loginUsuario = jwtService.obterLoginUsuario(token);
        UserDetails usuario = authAdapterPort.loadUserByUsername(loginUsuario);
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usuario,
            null, usuario.getAuthorities());
        user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(user);
      }


    }
    filterChain.doFilter(request, response);
  }

}
