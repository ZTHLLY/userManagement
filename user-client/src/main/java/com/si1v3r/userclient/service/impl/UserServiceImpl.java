package com.si1v3r.userclient.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.si1v3r.userclient.model.domain.User;
import com.si1v3r.userclient.service.UserService;
import com.si1v3r.userclient.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

/**
 *
 *
 * 用户服务实现类
* @author si1v3r
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-09-17 21:31:20
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public long UserRegister(String userAccount, String userPassword, String checkPassword) {
        //1. 校验
      if(StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)){
        return -1;
      }
      if(userAccount.length()<4){
        return -1;
      }
      if(userPassword.length()<8||checkPassword.length()<8){
        return -1;
      }



      //账号不能包含特殊字符
      String regEx =  ".*[\\s`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]+.*";
      Pattern p = Pattern.compile(regEx);
      Matcher m = p.matcher("a a)");
      boolean matches = m.matches();
      System.out.println(matches);


      //密码和校验密码相同
      if(!userPassword.equals(checkPassword)){
        return -1;
      }

      //账号不能重复
      QueryWrapper<User> queryWrapper=new QueryWrapper<>();
      queryWrapper.eq("userAccount",userAccount);
      long count = this.count(queryWrapper);
      if(count>0){
        return -1;
      }

      //加密
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.digest("abcd");

      return 0;
    }
}




