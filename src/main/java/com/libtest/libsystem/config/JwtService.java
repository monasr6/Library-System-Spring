package com.libtest.libsystem.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.libtest.libsystem.user.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  @Value("${application.security.jwt.secret-key}")
  private String key;

  
  
  public String createToken(User user) {
    return createToken(new HashMap<>(), user);
  }

  public String createToken(Map<String, Object> claims, UserDetails userDetails) {
    return Jwts.builder()
        .setIssuer("libsystem")
        .setIssuedAt(new java.util.Date())
        .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        .setSubject(userDetails.getUsername())
        .setClaims(claims)
        .setPayload(userDetails.getUsername())
        .signWith(getSignInKey(), SignatureAlgorithm.HS256)
        .compact();
  };

  public boolean validateToken(String token, UserDetails userDetails) {
    final String username = getEmail(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  private boolean isTokenExpired(String token) {
    Date expiration = extractClaim(token, Claims::getExpiration);
    return expiration.before(new Date());
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public String getEmail(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Claims getAllClaims(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSignInKey()).build()
        .parseClaimsJws(token)
        .getBody();
  }

  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(key);
    return Keys.hmacShaKeyFor(keyBytes);
  }

}