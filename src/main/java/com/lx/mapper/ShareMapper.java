package com.lx.mapper;

import com.lx.POJO.Share;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareMapper {
//    插入资源表
    void insertShare(@Param("userName")String userName,@Param("fileName")String fileName,@Param("clubId")int clubId);
//    根据社团id查询该社团所有资源
    List<Share> queryByClubId(int clubId);
//    删除已被销毁文件条目
    void deleteLostFile(String fileName);
//    获取今天的资源数量
    int queryTodayShareCount(@Param("today") String today,@Param("clubId") int clubId);
//    根据用户名获取该用户提交资源数量
    int queryShareCountByUserName(String userName);
//    根据社团id获取前六个资源
    List<Share> queryFirstSixShareByClubId(int clubId);
}
