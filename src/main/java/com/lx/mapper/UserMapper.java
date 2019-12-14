package com.lx.mapper;

import com.lx.POJO.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
//    查询所有用户
    List<User> queryAll();
//    插入用户
    void insertUser(User user);
//    判断用户是否存在
    int isHasName(String userName);
//    根据用户名密码查询用户
    User queryUserByUserNameAndPsw(@Param("userName") String userName, @Param("password") String password);
//    查询管理员数量
    int queryAdminCount();
}
