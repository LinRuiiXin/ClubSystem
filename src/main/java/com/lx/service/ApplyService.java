package com.lx.service;

import com.lx.POJO.Apply;

import java.util.List;

public interface ApplyService {
    void insertApply(Apply apply);
    List<Apply> queryAllByUserId(int userId);
}
