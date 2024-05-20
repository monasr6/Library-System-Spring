package com.libtest.libsystem.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AuthControllerTest {

  @Mock
  private AuthService authService;

  private AuthenticationController authenticationController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    authenticationController = new AuthenticationController(authService);
  }

  @Test
  void testRegister() {
    // Arrange
    RegisterReq request = new RegisterReq();
    request.setEmail("email@test.com");
    request.setRole("user");
    request.setName("name");
    request.setPassword("password");

    AuthenticationResponse expectedResponse = new AuthenticationResponse();
    expectedResponse.setEmail("email@test.com");
    expectedResponse.setRole("user");
    expectedResponse.setToken("token");
    
    when(authService.Register(request)).thenReturn(expectedResponse);

    // Act
    ResponseEntity<AuthenticationResponse> response = authenticationController.Register(request);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedResponse, response.getBody());
    verify(authService, times(1)).Register(request);
  }

  @Test
  void testLogin() {
    // Arrange
    LoginReq request = new LoginReq();
    request.setEmail("email@test.com");
    request.setPassword("password");

    AuthenticationResponse expectedResponse = new AuthenticationResponse();
    expectedResponse.setEmail("email@test.com");
    expectedResponse.setRole("user");
    expectedResponse.setToken("token");

    when(authService.Login(request)).thenReturn(expectedResponse);

    // Act
    ResponseEntity<AuthenticationResponse> response = authenticationController.Login(request);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedResponse, response.getBody());
    verify(authService, times(1)).Login(request);
  }
}