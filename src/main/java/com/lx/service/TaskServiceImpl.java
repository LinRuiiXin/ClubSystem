package com.lx.service;

import com.lx.POJO.Task;
import com.lx.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskMapper taskMapper;
    @Override
    public List<Task> queryAllByUserId(int userId) {
        List<Task> taskList = taskMapper.queryAllByUserId(userId);
        return taskList;
    }

    @Override
    public void updateStatusById(int id) {
        taskMapper.updateStatusById(id);
    }

    @Override
    public void insertTask(Task task) {
        taskMapper.insertTask(task);
    }

}
