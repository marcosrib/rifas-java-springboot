package com.rifas.trevorifas.security.jwt;

import com.rifas.trevorifas.application.core.domain.Auth;
import com.rifas.trevorifas.application.core.domain.User;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

  @Value("${security.jwt.expiracao}")
  private String expiracao;
  @Value("${security.jwt.assinatura}")
  private String chaveAssinatura;

  public String gerarToken(Auth auth) {
    Long expString = Long.valueOf(expiracao);
    LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
    Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
    Date data = Date.from(instant);

    HashMap<String, Object> claims = new HashMap<>();
    claims.put("email", auth.getEmail());
    //claims.put("nome", auth.getName);

    return Jwts
        .builder()
        .setSubject(auth.getEmail())
        .setExpiration(data)
        .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
        .compact();
  }

  public Claims obterClaims(String token) throws ExpiredJwtException {
    return Jwts
        .parser()
        .setSigningKey(chaveAssinatura)
        .parseClaimsJws(token)
        .getBody();
  }

  public boolean tokenValido(String token) {
    try {
      Claims claims = obterClaims(token);
      Date dataExpiracao = claims.getExpiration();
      System.err.println(token);
      System.err.println(dataExpiracao);
      LocalDateTime data =
          dataExpiracao.toInstant()
              .atZone(ZoneId.systemDefault()).toLocalDateTime();
      return !LocalDateTime.now().isAfter(data);
    } catch (Exception e) {
      return false;
    }
  }

  public String obterLoginUsuario(String token) throws ExpiredJwtException {
    return (String) obterClaims(token).getSubject();
  }
}
