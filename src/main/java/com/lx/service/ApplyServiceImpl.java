package com.lx.service;

import com.lx.POJO.Apply;
import com.lx.mapper.ApplyMapper;
import com.lx.mapper.UserMapper;
import com.lx.utils.ApplyProgressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public void insertApply(Apply apply) {
        applyMapper.insertApply(apply);
    }

    @Override
    public List<Apply> queryAllByUserId(int userId) {
        List<Apply> applies = applyMapper.queryAllByUserId(userId);
//            获取当前申请进度
        List<Apply> applyWithProgressList = ApplyProgressUtil.getProgress(applies);
        return applyWithProgressList;
    }
}
