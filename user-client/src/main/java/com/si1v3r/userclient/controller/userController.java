package com.si1v3r.userclient.controller;



import com.si1v3r.userclient.model.domain.User;
import com.si1v3r.userclient.model.domain.request.UserLoginRequest;
import com.si1v3r.userclient.service.UserService;
import com.si1v3r.userclient.model.domain.request.UserRegisterRequest;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
    if(userRegisterRequest==null){
      return null;
    }
    String userAccount = userRegisterRequest.getUserAccount();
    String userPassword = userRegisterRequest.getUserPassword();
    String checkPassword = userRegisterRequest.getCheckPassword();
    if(StringUtils.isAnyBlank(userAccount,userPassword,checkPassword)){
      return null;
    }
    return userService.UserRegister(userAccount, userPassword, checkPassword);
  }

  @PostMapping("/login")
  public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
    if(userLoginRequest==null){
      return null;
    }
    String userAccount = userLoginRequest.getUserAccount();
    String userPassword = userLoginRequest.getUserPassword();
    if(StringUtils.isAnyBlank(userAccount,userPassword)){
      return null;
    }
    return userService.userLogin(userAccount, userPassword,request);
  }




}
