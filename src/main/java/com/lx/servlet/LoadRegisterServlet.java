package com.lx.servlet;

import com.lx.POJO.Club;
import com.lx.dto.Result;
import com.lx.service.ClubService;
import com.lx.utils.JsonUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loadRegisterServlet")
public class LoadRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        ClubService clubService = context.getBean(ClubService.class);
        List<Club> clubs = clubService.queryAll();
        JsonUtils.returnJson(resp,new Result(0,"成功",clubs));
    }
}
