package com.lx.POJO;



import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Share {
    private int id;
    private String userName;
    private String fileName;
    @JSONField(format = "yyyy-MM-dd")
    private Date uploadTime;
    private int clubId;

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public Date getUploadTime() {
        return uploadTime;
    }
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadTime=" + uploadTime +
                ", clubId=" + clubId +
                '}';
    }
}
