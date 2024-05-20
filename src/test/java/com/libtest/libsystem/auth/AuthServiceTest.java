package com.libtest.libsystem.auth;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.libtest.libsystem.config.JwtService;
import com.libtest.libsystem.user.Role;
import com.libtest.libsystem.user.User;
import com.libtest.libsystem.user.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any; // Add this import statement
import static org.mockito.Mockito.when; // Add this import statement
import static org.mockito.Mockito.times; // Add this import statement
import static org.mockito.Mockito.verify; // Add this import statement

class AuthServiceTest {

  @Mock
  private UserRepository userRepository;
  
  @Mock
  private JwtService jwtService;
  
  @Mock
  private AuthenticationManager authenticationManager;
  
  @Mock
  private PasswordEncoder passwordEncoder;
  
  private AuthService authService;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    authService = new AuthService(userRepository, jwtService, authenticationManager, passwordEncoder);
  }
  
  @Test
  void testRegister() {
    // Arrange
    RegisterReq request = new RegisterReq();
    request.setEmail("email@test.com");
    request.setPassword("password");
    request.setName("John Doe");
    // ...

    User user = User.builder()
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .name(request.getName())
        .build();
        

    when(userRepository.save(any(User.class))).thenReturn(user); // Add .class after User
    when(jwtService.createToken(any(User.class))).thenReturn("token"); // Add .class after User

    AuthenticationResponse response = authService.Register(request);

    assertEquals("token", response.getToken());
    assertEquals("email@test.com", response.getEmail());
    assertEquals("USER", response.getRole());
    verify(userRepository, times(1)).save(any(User.class));
    verify(jwtService, times(1)).createToken(any(User.class));
  }

  @Test
  void testAuthenticationResponse() {
    // Arrange
    String email = "email@test.com";
    String role = "user";
    String token = "token";

    // Act
    AuthenticationResponse response = new AuthenticationResponse();
    response.setEmail(email);
    response.setRole(role);
    response.setToken(token);

    // Assert
    assertEquals(email, response.getEmail());
    assertEquals(role, response.getRole());
    assertEquals(token, response.getToken());
  }
  
  @Test
  void testAuthenticationResponseBuilder() {
    // Arrange
    String email = "email@test.com";
    String role = "user";
    String token = "token";

    // Act
    AuthenticationResponse response = AuthenticationResponse.builder()
        .email(email)
        .role(role)
        .token(token)
        .build();

    // Assert
    assertEquals(email, response.getEmail());
    assertEquals(role, response.getRole());
    assertEquals(token, response.getToken());
  }
}