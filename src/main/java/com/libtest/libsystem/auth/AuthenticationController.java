package com.libtest.libsystem.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthService authService;


  @PostMapping("register")
  public ResponseEntity<AuthenticationResponse> Register(@RequestBody RegisterReq request) {
    return ResponseEntity.ok(authService.Register(request));
  }
  
  @PostMapping("login")
  public ResponseEntity<AuthenticationResponse> Login(@RequestBody LogingReq entity) {
      return ResponseEntity.ok(authService.Login(entity));
  }
  
}
