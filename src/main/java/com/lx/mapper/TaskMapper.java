package com.lx.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {
    int queryRemTask(int userId);
}
