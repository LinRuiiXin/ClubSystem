package com.lx.mapper;

import com.lx.POJO.Apply;
import org.apache.ibatis.annotations.Param;
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
//    根据id驳回申请（将状态改为1）
    void rejectApply(int applyId);
//    根据applyId删除缓冲表的数据
    void deleteDateInBuffer(int applyId);
//    根据id获取缓冲表条目数量
    int getCountByApplyIdInBuffer(int applyId);
    //    根据id通过申请（将状态改为2）
    void agreeApply(int applyId);
//    将数据插入缓冲表
    void insertToApplyBuffer(@Param("applyId") int applyId,@Param("adminId") int adminId);
//    翻页查看apply
    List<Apply> queryApplyBySAndE(@Param("clubId") int clubId,@Param("start") int start,@Param("end")int end);
}
