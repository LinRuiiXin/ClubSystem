package com.lx.mapper;

import com.lx.POJO.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> queryAll();
    void insertUser(User user);
    int isHasName(String userName);
    User queryUserByUserNameAndPsw(@Param("userName") String userName, @Param("password") String password);
    int queryAdminCount();
}
