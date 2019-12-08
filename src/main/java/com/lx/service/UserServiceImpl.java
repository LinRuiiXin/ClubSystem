package com.lx.service;

import com.lx.POJO.User;
import com.lx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public boolean isHasName(String userName) {
        int count = userMapper.isHasName(userName);
        if(count == 0){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public User queryUserByUserNameAndPsw(String userName, String password) {
        User user = userMapper.queryUserByUserNameAndPsw(userName, password);
        return user;
    }
}
