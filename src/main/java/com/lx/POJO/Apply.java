package com.lx.POJO;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Apply{
    private int id;
    private int userId;
    private int money;
    private String reason;
    @JSONField(format = "yyyy-MM-dd")
    private Date applyDate;
    private int status;
    private int clubId;
    private String statusInfo;
    public Apply(){

    }
    public Apply(int id, int userId, int money, String reason, Date applyDate, int status, int clubId) {
        this.id = id;
        this.userId = userId;
        this.money = money;
        this.reason = reason;
        this.applyDate = applyDate;
        this.status = status;
        this.clubId = clubId;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }


    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", userId=" + userId +
                ", money=" + money +
                ", reason='" + reason + '\'' +
                ", applyDate=" + applyDate +
                ", status=" + status +
                ", clubId=" + clubId +
                ", statusInfo='" + statusInfo + '\'' +
                '}';
    }
}
