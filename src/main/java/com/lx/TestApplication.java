package com.lx;

import com.alibaba.fastjson.JSON;
import com.lx.POJO.*;
import com.lx.mapper.ShareMapper;
import com.lx.mapper.UserMapper;
import com.lx.mapper.WorkTimeMapper;
import com.lx.service.ApplyService;
import com.lx.service.LoadIndexService;
import com.lx.service.WorkTimeService;
import com.lx.utils.DateUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestApplication {
    @Test
    public void m1() throws IOException {
        String res = "MyBatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(res);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryAll();
        System.out.println(users);
    }
    @Test
    public void m2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        UserMapper bean = context.getBean(UserMapper.class);
        User user = bean.queryUserByUserNameAndPsw("111", "11111");
        System.out.println(user);
    }
    @Test
    public void m3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> users = userMapper.queryAll();
        User user = users.get(0);
        user.setId(0);
        user.setRegisterTime(null);
        userMapper.insertUser(user);
    }
    @Test
    public void m4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        UserMapper bean = context.getBean(UserMapper.class);
        int hasName = bean.isHasName("sda啊是大");
        System.out.println(hasName);
    }
    @Test
    public void m5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> users = userMapper.queryAll();
        System.out.println(users);
    }
    @Test
    public void m6(){
        try {
            InputStream inputStream = new FileInputStream("t.jpg");
            OutputStream outputStream = new FileOutputStream("d://upload");
            byte[] buffer = new byte[1024];
            int len;
            while((len=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void m7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        ShareMapper bean = context.getBean(ShareMapper.class);
        List<Share> shares = bean.queryByClubId(0);
        String s = JSON.toJSONString(shares);
        System.out.println(s);
    }
    @Test
    public void m8(){
        Share share = new Share();
        share.setUploadTime(new Date());
        System.out.println(JSON.toJSONString(share));
    }
    @Test
    public void m9(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
    @Test
    public void m10(){
        String startDate = DateUtil.getStartDate();
        System.out.println(startDate);
        String endDate = DateUtil.getEndDate();
        System.out.println(endDate);
    }
    @Test
    public void m11(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        LoadIndexService loadIndexService = context.getBean(LoadIndexService.class);
        User user = new User();
        user.setId(51);
        user.setClubId(0);
        IndexInfo indexInfo = loadIndexService.getIndexInfo(user);
        System.out.println(indexInfo);
    }
    @Test
    public void m12(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        ApplyService applyService = context.getBean(ApplyService.class);
        List<Apply> applies = applyService.queryRemApplyByClubIdAndAdminId(1, 65);
        System.out.println(applies);
    }
    @Test
    public void m13(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        WorkTimeMapper bean = context.getBean(WorkTimeMapper.class);
        List<Integer> checkInCount = bean.getCheckInCount(0, "2018-1-1", "2020-1-1");
        System.out.println(checkInCount);
    }
    @Test
    public void m14(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        WorkTimeService bean = context.getBean(WorkTimeService.class);
        List<Integer> checkInCount15Days = bean.getCheckInCount15Days(0);
        System.out.println(checkInCount15Days);
    }
    @Test
    public void m15(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        WorkTimeMapper bean = context.getBean(WorkTimeMapper.class);
        List<WorkTime> workTimes = bean.queryPastCheckInTreat(0, "2019-12-16");
        System.out.println(workTimes);
    }
}
