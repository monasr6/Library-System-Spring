package com.libtest.libsystem.config;

import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
  SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("secret"));

  public String createToken(String id, String name) {
    return Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setHeaderParam("regDate", System.currentTimeMillis())
        .setSubject("user")
        .claim("id", id)
        .claim("name", name)
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();

  };

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public String getId(String token) {
    return extractClaim(token, Claims::getId);
  }

  public String getName(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Claims getAllClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(key).build()
        .parseClaimsJws(token)
        .getBody();
  }
}