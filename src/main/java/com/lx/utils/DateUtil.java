package com.lx.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    public static String getStartDate(){
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH)+1;
        String startDate = year +"-"+ month +"-"+ "0";
        return startDate;
    }
    public static String getEndDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int maximum = calendar.getMaximum(Calendar.DAY_OF_MONTH);
        String endDate = year +"-"+ month +"-"+ maximum;
        return endDate;
    }
    public static Map<String,String> getStartAndEndDateByMonth(int month){
        Map<String,String> map = new HashMap<String,String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year,month,0);
        String startDate = year +"-"+ month +"-"+ 0;
        map.put("startDate",startDate);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String endDate = year +"-"+ month +"-"+ maxDay;
        map.put("endDate",endDate);
        return map;
    }
}
