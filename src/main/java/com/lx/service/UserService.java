package com.lx.service;

import com.lx.POJO.User;

public interface UserService {
    void insertUser(User user);
    boolean isHasName(String userName);
    User queryUserByUserNameAndPsw(String userName,String password);
}
