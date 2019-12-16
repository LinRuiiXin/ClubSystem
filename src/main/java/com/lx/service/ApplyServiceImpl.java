package com.lx.service;

import com.lx.POJO.Apply;
import com.lx.mapper.ApplyMapper;
import com.lx.mapper.UserMapper;
import com.lx.utils.ApplyProgressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService{
    @Autowired
    ApplyMapper applyMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public void insertApply(Apply apply) {
        applyMapper.insertApply(apply);
    }

    @Override
    public List<Apply> queryAllByUserId(int userId) {
        List<Apply> applies = applyMapper.queryAllByUserId(userId);
//            获取当前申请进度
        List<Apply> applyWithProgressList = ApplyProgressUtil.getProgress(applies);
        return applyWithProgressList;
    }
    @Override
    public boolean checkStatus(int userId) {
        Apply apply = applyMapper.queryLastApplyByUserId(userId);
        if(apply == null){
            return true;
        }else{
            if(apply.getStatus() == 0){
                return false;
            }else{
                return true;
            }
        }
    }
    @Override
    public List<Apply> queryRemApplyByClubIdAndAdminId(int clubId,int adminId){
        List<Apply> applies = applyMapper.queryRemApplyByClubId(clubId);
        List<Apply> remApply = new ArrayList<Apply>();
        for(Apply apply:applies){
            List<Integer> adminIds = applyMapper.queryAdminIdByApplyId(apply.getId());
            if(adminIds == null){
                remApply.add(apply);
            }else{
                boolean status = true;
                for(int id:adminIds){
                    if(id == adminId){
                        status = false;
                        break;
                    }
                }
                if(status){
                    remApply.add(apply);
                }
            }
        }
        return remApply;
    }

    @Override
    public void rejectApply(int applyId) {
        applyMapper.rejectApply(applyId);
        applyMapper.deleteDateInBuffer(applyId);
    }

    @Override
    public boolean isLastOne(int applyId) {
        int countByApplyIdInBuffer = applyMapper.getCountByApplyIdInBuffer(applyId);
        int adminCount = userMapper.queryAdminCount();
        if(countByApplyIdInBuffer == adminCount-1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void handleLastApply(int applyId) {
        applyMapper.deleteDateInBuffer(applyId);
        applyMapper.agreeApply(applyId);
    }

    @Override
    public void insertToApplyBuffer(int applyId, int adminId) {
        applyMapper.insertToApplyBuffer(applyId,adminId);
    }

    @Override
    public List<Apply> turnPage(int clubId, int page) {
        int start = (page-1)*6;
        int end = page*6;
        List<Apply> applies = applyMapper.queryApplyBySAndE(clubId, start, end);
        List<Apply> applyList = ApplyProgressUtil.getProgress(applies);
        return applyList;
    }

}
