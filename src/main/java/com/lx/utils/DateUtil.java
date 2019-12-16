package com.lx.utils;

import java.text.SimpleDateFormat;
import java.util.*;

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
    public static String getStartTime(){
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int year = instance.get(Calendar.YEAR);
        int month= instance.get(Calendar.MONTH)+1;
        String startTime = year+"-"+month+"-"+"0";
        return startTime;
    }
    public static String getEndTime(){
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH)+1;
        int day = instance.getMaximum(Calendar.DAY_OF_MONTH);
        String endTime = year +"-"+month+"-"+day;
        return endTime;
    }
    public static boolean isRepeatDate(List<Integer> days, int day){
        //找到已签到的日期
        int flag = 0;
        for (int i=0;i<days.size();i++){
            if (day==days.get(i)){
                flag = 1;
            }else {
                flag = 0;
            }
        }
        if (flag == 1) {
            return true;
        }else {
            return false;
        }
    }
    public static int getDateDay(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        int day = Integer.valueOf(format.split("-")[2]);
        return day;
    }
}
