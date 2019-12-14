package com.lx.service;

import com.lx.POJO.*;
import com.lx.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoadAdminIndexServiceImpl implements LoadAdminIndexService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ShareMapper shareMapper;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    ApplyService applyService;
    @Autowired
    WorkTimeMapper workTimeMapper;
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public AdminIndexInfo getAdminIndexInfo(User user) {
        AdminIndexInfo adminIndexInfo = new AdminIndexInfo();
        int clubId = user.getClubId();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(new Date());
        int todayCheckedCount = workTimeMapper.queryCountCheckedToday(clubId, today);
        adminIndexInfo.setCheckInToday(todayCheckedCount);
        int noticeToday = noticeMapper.queryNoticeToday(clubId, today);
        adminIndexInfo.setTodayNotice(noticeToday);
        List<Apply> applyList = applyService.queryRemApplyByClubIdAndAdminId(clubId, user.getId());
        adminIndexInfo.setApplyToDo(applyList.size());
        int shareToady = shareMapper.queryTodayShareCount(today, clubId);
        adminIndexInfo.setShareToday(shareToady);
        List<Notice> noticeList = noticeMapper.queryFirstThreeNotice(clubId);
        adminIndexInfo.setNoticeList(noticeList);
        int shareCount = shareMapper.queryShareCountByUserName(user.getUserName());
        adminIndexInfo.setShareCount(shareCount);
        int remTask = taskMapper.queryUserRemTask(user.getUserName());
        adminIndexInfo.setTaskCount(remTask);
        List<Share> shares = shareMapper.queryFirstSixShareByClubId(clubId);
        adminIndexInfo.setShareList(shares);
        return adminIndexInfo;
    }
}
