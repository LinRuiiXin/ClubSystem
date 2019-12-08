package com.lx.servlet;

import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.UserService;
import com.lx.utils.JsonUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            URLDecoder.decode((String)req.getParameter("userName"),"UTF-8");
            String name = req.getParameter("userName").trim();
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Application.xml");
            UserService userService = applicationContext.getBean(UserService.class);
            if(userService.isHasName(name)){
                JsonUtils.returnJson(resp,new Result(1,"已存在同名用户",null));
            }else{
                String year = req.getParameter("year");
                String month = req.getParameter("month");
                String day = req.getParameter("day");
                String birthday = year + "-" + month + "-" + day;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse(birthday);
                long time = date.getTime();
                time+=(1000*60*60*24);
                date.setTime(time);
                User user = new User();
                BeanUtils.populate(user,req.getParameterMap());
                user.setBirthday(date);
                userService.insertUser(user);
                System.out.println(user);
                Result result = new Result(0,"成功",user);
                JsonUtils.returnJson(resp,result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(1,"失败",null);
            JsonUtils.returnJson(resp,result);
        }
    }
}