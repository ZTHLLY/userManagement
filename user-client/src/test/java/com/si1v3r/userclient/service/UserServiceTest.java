package com.si1v3r.userclient.service;
import java.util.Date;

import com.si1v3r.userclient.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
* 用户服务测试
*
* @author si1v3r
*
* */

@SpringBootTest
public class UserServiceTest {


  @Resource
  private UserService userService;


  @Test
  public void testAddUser(){


    User user=new User();
    user.setUsername("test01");
    user.setUserAccount("123");
    user.setAvatarUrl("https://s2.loli.net/2022/11/27/iSobIY1cF6KzV5O.jpg");
    user.setGender(0);
    user.setUserPassword("xxx");
    user.setPhone("123");
    user.setEmail("456");

    boolean result=userService.save(user);

    System.out.println(user.getId());
    Assertions.assertTrue(result);




  }
}
