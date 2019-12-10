package com.lx.service;

import com.lx.POJO.Apply;
import com.lx.POJO.IndexInfo;
import com.lx.POJO.Share;
import com.lx.POJO.User;
import com.lx.mapper.*;
import com.lx.utils.ApplyProgressUtil;
import com.lx.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoadIndexServiceImpl implements LoadIndexService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    WorkTimeMapper workTimeMapper;
    @Autowired
    TaskMapper taskMapper;
    @Override
    public IndexInfo getIndexInfo(User user) {
        int userId = user.getId();
        IndexInfo indexInfo = new IndexInfo();
        String startDate = DateUtil.getStartDate();
        String endDate = DateUtil.getEndDate();
        int checkInCount = workTimeMapper.queryCountByIdStEt(userId, startDate, endDate);
        indexInfo.setCheckInCount(checkInCount);
        int remTask = taskMapper.queryRemTask(userId);
        indexInfo.setRemTask(remTask);
        Apply apply = applyMapper.queryLastApplyByUserId(userId);
        String lastApplyProgress = ApplyProgressUtil.getLastApplyProgress(apply);
        indexInfo.setApplyProgress(lastApplyProgress);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(new Date());
        int todayShareCount = shareMapper.queryTodayShareCount(today, user.getClubId());
        indexInfo.setTodayShare(todayShareCount);
        int shareCountByUserName = shareMapper.queryShareCountByUserName(user.getUserName());
        indexInfo.setShareCount(shareCountByUserName);
        int applyCountById = applyMapper.queryCountByUserId(userId);
        indexInfo.setApplyCount(applyCountById);
        List<Share> shares = shareMapper.queryFirstSixShareByClubId(user.getClubId());
        indexInfo.setShares(shares);
        return indexInfo;
    }
}
