package com.libtest.libsystem.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {
  private String email;
  private String password;
  private String role;
  private String name;
}
