package com.lx.service;

import com.lx.POJO.Share;
import com.lx.mapper.ShareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareMapper shareMapper;

    @Override
    public void insertShare(String userName, String fileName,int clubId) {
        shareMapper.insertShare(userName,fileName,clubId);
    }

    @Override
    public List<Share> queryByClubId(int clubId) {
        List<Share> shares = shareMapper.queryByClubId(clubId);
        return shares;
    }

    @Override
    public void deleteLostFile(String fileName) {
        shareMapper.deleteLostFile(fileName);
    }

}
