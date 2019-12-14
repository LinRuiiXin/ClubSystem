package com.lx.mapper;

import com.lx.POJO.Apply;
import com.lx.POJO.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyMapper {
//    插入申请
    void insertApply(Apply apply);
//    查询本人的申请记录
    List<Apply> queryAllByUserId(int userId);
//    获取已通过数量
    int getPassCountByApplyId(int applyId);
//    获取最后一次申请
    Apply queryLastApplyByUserId(int userId);
//    获取申请总数
    int queryCountByUserId(int userId);
//    获取社团审核未通过申请
    List<Apply> queryRemApplyByClubId(int clubId);
//    根据申请id获取已审核管理员id(缓冲表)
    List<Integer> queryAdminIdByApplyId(int applyId);
}
