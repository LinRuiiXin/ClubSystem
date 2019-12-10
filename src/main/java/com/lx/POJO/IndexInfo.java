package com.lx.POJO;

import java.util.List;

public class IndexInfo {
//    本月签到天数
    private int checkInCount;
//    剩余任务
    private int RemTask;
//    申请进度
    private String applyProgress;
//    今日资源
    private int todayShare;
//    贡献
    private int shareCount;
//    申请总数
    private int applyCount;
//    前六个资源
    private List<Share> shares;

    public int getCheckInCount() {
        return checkInCount;
    }

    public void setCheckInCount(int checkInCount) {
        this.checkInCount = checkInCount;
    }

    public int getRemTask() {
        return RemTask;
    }

    public void setRemTask(int remTask) {
        RemTask = remTask;
    }

    public String getApplyProgress() {
        return applyProgress;
    }

    public void setApplyProgress(String applyProgress) {
        this.applyProgress = applyProgress;
    }

    public int getTodayShare() {
        return todayShare;
    }

    public void setTodayShare(int todayShare) {
        this.todayShare = todayShare;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(int applyCount) {
        this.applyCount = applyCount;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "IndexInfo{" +
                "checkInCount=" + checkInCount +
                ", RemTask=" + RemTask +
                ", applyProgress='" + applyProgress + '\'' +
                ", todayShare=" + todayShare +
                ", shareCount=" + shareCount +
                ", applyCount=" + applyCount +
                ", shares=" + shares +
                '}';
    }
}
