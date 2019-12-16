package com.lx.service;

import com.lx.POJO.Notice;
import com.lx.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> queryAllByClubId(int clubId) {
        List<Notice> noticeList = noticeMapper.queryAllByClubId(clubId);
        return noticeList;
    }

    @Override
    public List<Notice> queryAllById(int id) {
        List<Notice> noticeList = noticeMapper.queryAllById(id);
        return noticeList;
    }

    @Override
    public void insertNotice(Notice notice) {
        noticeMapper.insertNotice(notice);
    }

    @Override
    public void deleteNoticeById(int id) {
        noticeMapper.deleteNoticeById(id);
    }
}
