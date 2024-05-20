package com.libtest.libsystem.health;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class healthController {

  @GetMapping("health")
  public String getMethodName() {
    return "OK";
  }

}
