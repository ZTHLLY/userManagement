package com.si1v3r.userclient.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.si1v3r.userclient.model.domain.User;
import com.si1v3r.userclient.service.UserService;
import com.si1v3r.userclient.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author silverbullets
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-09-17 21:31:20
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




