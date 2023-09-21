package com.si1v3r.userclient.model.domain.request;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author si1v3r
 */
@Data
public class UserRegisterRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = -1000294604230024896L;

  private String userAccount;
  private String userPassword;
  private String checkPassword;

}
