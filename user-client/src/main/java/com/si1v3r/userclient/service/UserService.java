package com.si1v3r.userclient.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.si1v3r.userclient.model.domain.User;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 用户逻辑
 *
 * @author si1v3r
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-09-17 21:31:20
 */
public interface UserService extends IService<User> {
  /**
   * 用户注册
   *
   * @param userAccount   用户账户
   * @param userPassword  用户密码
   * @param checkPassword 校验密码
   * @return 新用户 id
   */


  long UserRegister(String userAccount, String userPassword, String checkPassword, String userCode);

  /**
   * 用户登录
   *
   * @param userAccount  用户账户
   * @param userPassword 用户密码
   * @param request      网络请求
   * @return user 脱敏用户信息
   */
  User userLogin(String userAccount, String userPassword, HttpServletRequest request);

  /**
   * 用户脱敏
   * @param originUser
   * @return
   */
  User getCleanUser(User originUser);

  /**
   * 用户注销
   * @param request 网络请求
   * @return 成功or失败
   */
  int userLogout(HttpServletRequest request);
}
