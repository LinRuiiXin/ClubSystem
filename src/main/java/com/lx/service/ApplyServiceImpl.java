package com.lx.service;

import com.lx.POJO.Apply;
import com.lx.mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyMapper applyMapper;
    @Override
    public void insertApply(Apply apply) {
        applyMapper.insertApply(apply);
    }

    @Override
    public List<Apply> queryAll() {
        List<Apply> applies = applyMapper.queryAll();
        return applies;
    }
}
