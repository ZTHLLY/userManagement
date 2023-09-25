package com.si1v3r.userclient.service;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import com.si1v3r.userclient.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

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
  public void testDigest() throws NoSuchAlgorithmException {
    String newPassword = DigestUtils.md5DigestAsHex(("abcd" + "mypassword").getBytes(StandardCharsets.UTF_8));
    System.out.println(newPassword);
  }

  @Test
  public void testAddUser(){


    User user=new User();
    user.setUsername("test02");
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

  @Test
  void userRegister() {

//    String userAccount="si1v3r";
//    String userPassword="123456789";
//    String checkPassword="123456789";

    String userAccount="si1v3r";
    String userPassword="";
    String checkPassword="123456789";
    long testResult=userService.UserRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,testResult);
    //账号小于4位
    userAccount="aa";
    userPassword="123456789";
    checkPassword="123456789";
    testResult=userService.UserRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,testResult);
    //密码小于8位
    userAccount="si1v3r1111";
    userPassword="1234";
    checkPassword="1234";
    testResult=userService.UserRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,testResult);
    //账户重复
    userAccount="si1v3r";
    userPassword="123456789";
    checkPassword="123456789";
    testResult=userService.UserRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,testResult);
    //密码和重复密码不同
    userAccount="si1v3rPro";
    userPassword="123456789";
    checkPassword="1234567890000";
    testResult=userService.UserRegister(userAccount,userPassword,checkPassword);
    Assertions.assertEquals(-1,testResult);
    //成功注册
    userAccount="si1v3rPro";
    userPassword="123456789";
    checkPassword="123456789";
    testResult=userService.UserRegister(userAccount,userPassword,checkPassword);
    Assertions.assertTrue(testResult>0);




  }
}
