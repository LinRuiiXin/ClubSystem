package com.lx.service;

import com.lx.POJO.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> queryAllByClubId(int clubId);
    List<Notice> queryAllById(int id);
    void insertNotice(Notice notice);
    void deleteNoticeById(int id);
}
