package com.lx.mapper;

import com.lx.POJO.Apply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyMapper {
    void insertApply(Apply apply);
    List<Apply> queryAllByUserId(int userId);
    int getPassCountByApplyId(int applyId);
    Apply queryLastApplyByUserId(int userId);
    int queryCountByUserId(int userId);
}
