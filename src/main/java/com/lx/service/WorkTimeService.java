package com.lx.service;

import java.util.List;

public interface WorkTimeService {
    List<Integer> queryWorkTimeByIdStEt(int userId,String startDate,String endDate);
}
