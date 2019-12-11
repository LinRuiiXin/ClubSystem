package com.lx.service;

import com.lx.POJO.Club;
import com.lx.mapper.ClubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService{
    @Autowired
    ClubMapper clubMapper;
    @Override
    public List<Club> queryAll() {
        List<Club> clubs = clubMapper.queryAllClub();
        return clubs;
    }
}
