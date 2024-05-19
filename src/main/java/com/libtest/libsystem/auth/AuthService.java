package com.libtest.libsystem.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.libtest.libsystem.config.JwtService;
import com.libtest.libsystem.user.Role;
import com.libtest.libsystem.user.User;
import com.libtest.libsystem.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

  public AuthenticationResponse Register(RegisterReq request) {
    User user = User.builder()
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .name(request.getName())
        .build();

    userRepository.save(user);

    var token = jwtService.createToken(user);

    return AuthenticationResponse.builder()
        .token(token)
        .email(user.getEmail())
        .role(user.getRole().name())
        .build();
  }

  public AuthenticationResponse Login(LogingReq request) {
    authenticationManager.authenticate (
        new UsernamePasswordAuthenticationToken(
          request.getEmail(), 
          request.getPassword()
          )
      );
      User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
      var token = jwtService.createToken(user);
      return AuthenticationResponse.builder()
        .token(token)
        .email(user.getEmail())
        .role(user.getRole().name())
        .build();
  }
}
