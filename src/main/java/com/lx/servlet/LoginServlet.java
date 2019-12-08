package com.lx.servlet;

import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.UserService;
import com.lx.utils.JsonUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("password");
        UserService userService = context.getBean(UserService.class);
        User user = userService.queryUserByUserNameAndPsw(userName, password);
        if(user == null){
            Result result = new Result(1,"账号或密码错误",null);
            JsonUtils.returnJson(resp,result);
        }else{
            Result result = new Result(0,"成功",user);
            req.getSession().setAttribute("User",user);
            JsonUtils.returnJson(resp,result);
        }
    }
}
