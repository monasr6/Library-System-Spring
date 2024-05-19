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

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> Register(@RequestBody RegisterReq request) {

    return null;

  }
  @PostMapping("login")
  public ResponseEntity<AuthenticationResponse> Login(@RequestBody LogingReq entity) {
      
      
      return null;
  }
  
}
