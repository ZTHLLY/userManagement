package com.si1v3r.userclient.service;

import com.si1v3r.userclient.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 * 用户逻辑
* @author si1v3r
* @description 针对表【user】的数据库操作Service
* @createDate 2023-09-17 21:31:20
*/
public interface UserService extends IService<User> {
  /**
   *
   * @param userAccount 用户账户
   * @param userPassword  用户密码
   * @param checkPassword  校验密码
   * @return 新用户 id
   */
  long UserRegister(String userAccount, String userPassword, String checkPassword);
}
