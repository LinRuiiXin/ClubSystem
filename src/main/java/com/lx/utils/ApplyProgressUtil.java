package com.lx.utils;

import com.lx.POJO.Apply;
import com.lx.mapper.ApplyMapper;
import com.lx.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.List;

public class ApplyProgressUtil {
    public static List<Apply> getProgress(List<Apply> applies){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        ApplyMapper applyMapper = context.getBean(ApplyMapper.class);
        for(Apply apply:applies){
            int status = apply.getStatus();
            switch (status){
                case 0:
                    int adminCount = userMapper.queryAdminCount();
                    int passCount = applyMapper.getPassCountByApplyId(apply.getId());
                    if(passCount == 0){
                        apply.setStatusInfo("未审核");
                    }else{
                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                        String format = decimalFormat.format((float) passCount / adminCount);
                        String progress = format.substring(2,4);
                        apply.setStatusInfo(progress+"%");
                    }
                    break;
                case 1:
                    apply.setStatusInfo("驳回");
                    break;
                case 2:
                    apply.setStatusInfo("成功");
                    break;
            }
        }
        return applies;
    }
    public static String getLastApplyProgress(Apply apply){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        ApplyMapper applyMapper = context.getBean(ApplyMapper.class);
        if(apply == null){
            return "0%";
        }else{
            if(apply.getStatus()==0){
                int adminCount = userMapper.queryAdminCount();
                int passCount = applyMapper.getPassCountByApplyId(apply.getId());
                if(passCount == 0){
                    return "0%";
                }else{
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    String format = decimalFormat.format((float) passCount / adminCount);
                    String progress = format.substring(2,4);
                    return progress+"%";
                }
            }else{
                return "0%";
            }
        }
    }
}
