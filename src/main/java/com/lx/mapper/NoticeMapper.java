package com.lx.mapper;

import com.lx.POJO.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    int queryNoticeToday(@Param("clubId") int clubId,@Param("today") String today);
    List<Notice> queryFirstThreeNotice(int clubId);
    List<Notice> queryAll();
    List<Notice> queryAllByClubId(@Param("clubId") int clubId);
    List<Notice> queryAllById(@Param("id") int id);
    void insertNotice(Notice notice);
    void deleteNoticeById(int id);
}
