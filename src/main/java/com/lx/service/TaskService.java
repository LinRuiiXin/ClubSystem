package com.lx.service;

import com.lx.POJO.Task;

import java.util.List;

public interface TaskService {
    List<Task> queryAllByUserId(int userId);
    void updateStatusById(int id);
    void insertTask(Task task);
}
