package com.lx.service;

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
}
