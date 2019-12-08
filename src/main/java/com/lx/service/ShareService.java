package com.lx.service;

import com.lx.POJO.Share;

import java.util.List;

public interface ShareService {
    void insertShare(String userName,String fileName,int clubId);
    List<Share> queryByClubId(int clubId);
    void deleteLostFile(String fileName);
}
