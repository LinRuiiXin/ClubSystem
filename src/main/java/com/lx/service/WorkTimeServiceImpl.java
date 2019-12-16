package com.lx.service;

import com.lx.POJO.WorkTime;
import com.lx.mapper.UserMapper;
import com.lx.mapper.WorkTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class WorkTimeServiceImpl implements WorkTimeService{
    @Autowired
    WorkTimeMapper workTimeMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<Integer> queryWorkTimeByIdStEt(int userId, String startDate, String endDate) {
        List<Date> dates = workTimeMapper.queryWorkTimeByIdStEt(userId, startDate, endDate);
        List<Integer> days = new ArrayList<Integer>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Date date:dates){
            String format = dateFormat.format(date);
            int day = Integer.valueOf(format.split("-")[2]);
            days.add(day);
        }
        return days;
    }

    @Override
    public List<Integer> getCheckInCount15Days(int clubId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String endDate = simpleDateFormat.format(date);
        long time = date.getTime();
        date.setTime(time-(1000*60*60*24*15));
        String startDate = simpleDateFormat.format(date);
        System.out.println(startDate);
        System.out.println(endDate);
        List<Integer> checkInCount = workTimeMapper.getCheckInCount(clubId, startDate, endDate);
        return checkInCount;
    }

    @Override
    public List<WorkTime> queryPastCheckInTreat(int clubId, int pastDay) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = date.getTime();
        date.setTime(time-(pastDay*(1000*60*60*24)));
        String checkInTime = dateFormat.format(date);
        List<WorkTime> workTimes = workTimeMapper.queryPastCheckInTreat(clubId, checkInTime);
        return workTimes;
    }

    @Override
    public List<String> userNotCheckIn(int clubId, int pastDay) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = date.getTime();
        date.setTime(time-(pastDay*(1000*60*60*24)));
        String checkInTime = dateFormat.format(date);
        List<String> list = userMapper.userNotCheckIn(clubId, checkInTime);
        return list;
    }

}
