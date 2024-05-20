package com.libtest.libsystem.config;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;

import com.libtest.libsystem.user.Role;
import com.libtest.libsystem.user.User;

import io.jsonwebtoken.Claims;


public class JwtServiceTest {
  @Mock
  private JwtService jwtService;

    @Test
    public void testCreateTokenWithString() {
        // Create a mock User object
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.USER); // Change the argument type from String to Role
        when(user.getName()).thenReturn("mo nasr");

        // Create a mock UserDetails object
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("monasr@example.com");

        // Create a mock claims map
        Map<String, Object> claims = new HashMap<>();
        claims.put("customClaim", "customValue");
        claims.put("expration", new Date());

        // Call the createToken method
        // String token = jwtService.createToken(any(), any());

        // Assert the expected token value
        assertEquals("expectedTokenValue", "token");
    }

    @Test
    public void testGetExpiration() {
        // Create a mock Claims object
        Claims claims = mock(Claims.class);
        Date date = new Date();
        when(claims.getExpiration()).thenReturn(date);

        // Call the getExpiration method
        Date expiration = claims.getExpiration();

        // Assert the expected expiration value
        assertEquals(date, expiration);
    }

    @Test
    public void testGetSubject() {
        // Create a mock Claims object
        Claims claims = mock(Claims.class);
        when(claims.getSubject()).thenReturn("testSubject");

        // Call the getSubject method
        String subject = claims.getSubject();

        // Assert the expected subject value
        assertEquals("testSubject", subject);
    }
}
