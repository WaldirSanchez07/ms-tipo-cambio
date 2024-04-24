package com.wcsp.pe.mstipocambio.infrastructure.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {

  @Value("${jwt.secret}")
  private String secret;

  @PostConstruct
  protected void init() {
    secret = Base64.getEncoder().encodeToString(secret.getBytes());
  }

  public String generarToken() {
    Date now = new Date();
    Date exp = new Date(now.getTime() + 3600000);
    return Jwts.builder()
            .setSubject("waldir")
            .setIssuedAt(now)
            .setExpiration(exp)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
  }

  public boolean validarToken(String authorization) {
    try {
      String token = authorization.substring(7);
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}