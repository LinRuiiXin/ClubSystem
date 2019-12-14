package com.lx.POJO;

import com.lx.POJO.Notice;

import java.util.List;

public class AdminIndexInfo {
    private int checkInToday;
    private int todayNotice;
    private int applyToDo;
    private int shareToday;
    private List<Notice> noticeList;
    private int taskCount;
    private int shareCount;
    private List<Share> shareList;

    public int getCheckInToday() {
        return checkInToday;
    }

    public void setCheckInToday(int checkInToday) {
        this.checkInToday = checkInToday;
    }

    public int getTodayNotice() {
        return todayNotice;
    }

    public void setTodayNotice(int todayNotice) {
        this.todayNotice = todayNotice;
    }

    public int getApplyToDo() {
        return applyToDo;
    }

    public void setApplyToDo(int applyToDo) {
        this.applyToDo = applyToDo;
    }

    public int getShareToday() {
        return shareToday;
    }

    public void setShareToday(int shareToday) {
        this.shareToday = shareToday;
    }

    public List<Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public List<Share> getShareList() {
        return shareList;
    }

    public void setShareList(List<Share> shareList) {
        this.shareList = shareList;
    }

    @Override
    public String toString() {
        return "AdminIndexInfo{" +
                "checkInToday=" + checkInToday +
                ", todayNotice=" + todayNotice +
                ", applyToDo=" + applyToDo +
                ", shareToday=" + shareToday +
                ", noticeList=" + noticeList +
                ", taskCount=" + taskCount +
                ", shareCount=" + shareCount +
                ", shareList=" + shareList +
                '}';
    }
}
