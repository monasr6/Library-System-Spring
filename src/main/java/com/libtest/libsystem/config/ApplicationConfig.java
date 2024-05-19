package com.libtest.libsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.libtest.libsystem.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService (){
    return email -> userRepository.findByEmail(email)
    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
  

}
