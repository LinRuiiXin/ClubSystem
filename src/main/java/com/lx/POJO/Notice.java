package com.lx.POJO;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Notice {
    private int id;
    private String title;
    private String message;
    private String releaseName;
    @JSONField(format = "yyyy-MM-dd")
    private Date releaseTime;
    private int clubId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", releaseName='" + releaseName + '\'' +
                ", releaseTime=" + releaseTime +
                ", clubId=" + clubId +
                '}';
    }
}
