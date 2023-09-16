package com.si1v3r.userclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/si1v3r/userclient/mapper")

public class UserClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserClientApplication.class, args);
  }

}
