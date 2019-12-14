package com.lx.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {
//    查询用户剩余任务数量
    int queryRemTask(int userId);
//    查询管理员发布的未完成的任务数量
    int queryUserRemTask(String releaseName);
}
