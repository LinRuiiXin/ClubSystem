package com.lx;

import com.alibaba.fastjson.JSON;
import com.lx.POJO.Share;
import com.lx.POJO.User;
import com.lx.mapper.ShareMapper;
import com.lx.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
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
}
