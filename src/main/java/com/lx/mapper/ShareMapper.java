package com.lx.mapper;

import com.lx.POJO.Share;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareMapper {
    void insertShare(@Param("userName")String userName,@Param("fileName")String fileName,@Param("clubId")int clubId);
    List<Share> queryByClubId(int clubId);
    void deleteLostFile(String fileName);
}
