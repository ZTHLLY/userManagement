package com.si1v3r.userclient;



import com.si1v3r.userclient.mapper.UserMapper;
import com.si1v3r.userclient.model.User;
import jakarta.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleTest {

  @Resource
  private UserMapper userMapper;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<User> userList = userMapper.selectList(null);
    Assert.assertEquals(5, userList.size());
    userList.forEach(System.out::println);
  }

}
