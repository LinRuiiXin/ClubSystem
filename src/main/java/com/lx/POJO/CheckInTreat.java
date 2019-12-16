package com.lx.POJO;

import java.util.List;

public class CheckInTreat {
    List<WorkTime> checkedWorkTimes;
    List<String> notCheckInList;

    public CheckInTreat(List<WorkTime> checkedWorkTimes, List<String> notCheckInList) {
        this.checkedWorkTimes = checkedWorkTimes;
        this.notCheckInList = notCheckInList;
    }

    public List<WorkTime> getCheckedWorkTimes() {
        return checkedWorkTimes;
    }

    public void setCheckedWorkTimes(List<WorkTime> checkedWorkTimes) {
        this.checkedWorkTimes = checkedWorkTimes;
    }

    public List<String> getNotCheckInList() {
        return notCheckInList;
    }

    public void setNotCheckInList(List<String> notCheckInList) {
        this.notCheckInList = notCheckInList;
    }

    @Override
    public String toString() {
        return "CheckInTreat{" +
                "checkedWorkTimes=" + checkedWorkTimes +
                ", notCheckInList=" + notCheckInList +
                '}';
    }
}
