package com.lx.mapper;

import com.lx.POJO.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {
//    查询用户剩余任务数量
    int queryRemTask(int userId);
//    查询管理员发布的未完成的任务数量
    int queryUserRemTask(String releaseName);
    List<Task> queryAllByUserId(int userId);
    void updateStatusById(int id);
    void insertTask(Task task);
}
