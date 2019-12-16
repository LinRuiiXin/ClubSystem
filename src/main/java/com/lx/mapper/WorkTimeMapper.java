package com.lx.mapper;

import com.lx.POJO.WorkTime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkTimeMapper {
//    根据id,开始时间,中止时间查询用户签已到的日期
    List<Date> queryWorkTimeByIdStEt(@Param("userId") int userId,@Param("startDate") String startDate,@Param("endDate") String endDate);
//    根据开始时间,中止时间查询用户签到数量
    int queryCountByIdStEt(@Param("userId") int userId,@Param("startDate") String startDate,@Param("endDate") String endDate);
//    获取今日社团内已签到人数
    int queryCountCheckedToday(@Param("clubId") int clubId,@Param("today") String today);
//    获取该社团几天内签到人数
    List<Integer> getCheckInCount(@Param("clubId") int clubId,@Param("startDate") String startDate,@Param("endDate") String endDate);
    List<WorkTime> queryPastCheckInTreat(@Param("clubId")int clubId,@Param("checkInTime")String checkInTime);
}
