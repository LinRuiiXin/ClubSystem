package com.lx.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkTimeMapper {
    List<Date> queryWorkTimeByIdStEt(@Param("userId") int userId,@Param("startDate") String startDate,@Param("endDate") String endDate);
    int queryCountByIdStEt(@Param("userId") int userId,@Param("startDate") String startDate,@Param("endDate") String endDate);
}
