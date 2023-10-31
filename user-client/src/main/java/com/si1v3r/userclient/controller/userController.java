package com.si1v3r.userclient.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.si1v3r.userclient.model.domain.User;
import com.si1v3r.userclient.model.domain.request.UserLoginRequest;
import com.si1v3r.userclient.service.UserService;
import com.si1v3r.userclient.model.domain.request.UserRegisterRequest;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.si1v3r.userclient.constant.userConstant.ADMIN_ROLE;
import static com.si1v3r.userclient.constant.userConstant.USER_LOGIN_STATE;

/**
 * 用户接口
 *
 * @author si1v3r
 */
@RestController
@RequestMapping("/user")
public class userController {

  @Resource
  private UserService userService;

  @PostMapping("/register")
  public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
    if (userRegisterRequest == null) {
      return null;
    }
    String userAccount = userRegisterRequest.getUserAccount();
    String userPassword = userRegisterRequest.getUserPassword();
    String checkPassword = userRegisterRequest.getCheckPassword();
    if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
      return null;
    }
    return userService.UserRegister(userAccount, userPassword, checkPassword);
  }

  @PostMapping("/login")
  public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
    if (userLoginRequest == null) {
      return null;
    }
    String userAccount = userLoginRequest.getUserAccount();
    String userPassword = userLoginRequest.getUserPassword();
    if (StringUtils.isAnyBlank(userAccount, userPassword)) {
      return null;
    }
    return userService.userLogin(userAccount, userPassword, request);
  }

  @GetMapping("/current")
  public User getCurrentUser(HttpServletRequest request){
    Object userAttribute = request.getSession().getAttribute(USER_LOGIN_STATE);
    User currentUser=(User) userAttribute;
    if(currentUser==null){
      return null;
    }
    long userId=currentUser.getId();
    //TODO: 校验用户是否合法
    User user = userService.getById(userId);
    return userService.getCleanUser(user);
  }


  @GetMapping("/search")
  public List<User> userSearch(String username, HttpServletRequest request) {
    if(!isAdmin(request)){
      return new ArrayList<>();
    }

    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    if (StringUtils.isNoneBlank(username)) {
      queryWrapper.like("username", username);
    }
    List<User> userList = userService.list(queryWrapper);

    return userList.stream().map(user -> {
      user.setUserPassword(null);
      return userService.getCleanUser(user);
    }).collect(Collectors.toList());
  }

  @PostMapping("/delete")
  public boolean deleteUser(@RequestBody long id, HttpServletRequest request){
    if(!isAdmin(request)){
      return false;
    }
    if(id<=0){
      return false;
    }
    return userService.removeById(id);
  }

  /**
   * 是否为管理员
   * @param request
   * @return
   */
  private boolean isAdmin(HttpServletRequest request){
    //鉴权
    Object userAttribute = request.getSession().getAttribute(USER_LOGIN_STATE);
    User user = (User) userAttribute;
    return user != null && user.getUserRole() == ADMIN_ROLE;
  }
}
