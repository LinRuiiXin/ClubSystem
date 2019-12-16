package com.lx.service;

import com.lx.POJO.Apply;

import java.util.List;

public interface ApplyService {
    void insertApply(Apply apply);
    List<Apply> queryAllByUserId(int userId);
    boolean checkStatus(int userId);
    List<Apply> queryRemApplyByClubIdAndAdminId(int clubId,int adminId);
    void rejectApply(int applyId);
    boolean isLastOne(int applyId);
    void handleLastApply(int applyId);
    void insertToApplyBuffer(int applyId,int adminId);
    List<Apply> turnPage(int clubId,int page);
}
