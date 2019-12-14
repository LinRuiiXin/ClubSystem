package com.lx.service;

import com.lx.POJO.AdminIndexInfo;
import com.lx.POJO.User;

public interface LoadAdminIndexService {
    AdminIndexInfo getAdminIndexInfo(User user);
}
