package com.si1v3r.userclient.model.domain.request;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author si1v3r
 */
@Data
public class UserLoginRequest implements Serializable {
  @Serial
  private static final long serialVersionUID = 4208994927662203120L;

  private String userAccount;
  private String userPassword;

}

