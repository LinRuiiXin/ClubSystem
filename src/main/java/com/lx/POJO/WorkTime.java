package com.lx.POJO;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class WorkTime {
    private int id;
    private int userId;
    @JSONField(format = "yyyy-MM-dd")
    private Date checkInTime;
    private int clubId;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "WorkTime{" +
                "id=" + id +
                ", userId=" + userId +
                ", checkInTime=" + checkInTime +
                ", clubId=" + clubId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
