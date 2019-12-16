package com.lx.service;

import com.lx.POJO.WorkTime;

import java.util.List;

public interface WorkTimeService {
    List<Integer> queryWorkTimeByIdStEt(int userId,String startDate,String endDate);
    List<Integer> getCheckInCount15Days(int clubId);
    List<WorkTime> queryPastCheckInTreat(int clubId,int pastDay);
    List<String> userNotCheckIn(int clubId,int pastDay);
}
