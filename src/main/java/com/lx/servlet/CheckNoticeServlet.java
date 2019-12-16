package com.lx.servlet;

import com.lx.dto.Result;
import com.lx.utils.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/checkNoticeServlet")
public class CheckNoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        String id = req.getParameter("id");
        //从session中获取noticeid
        //根据noticeid获取notice
        if (id== null) {
            Result result = new Result(1, "找不到记录", null);
            JsonUtil.ReturnJson(resp, result);
        } else {
            Result result = new Result(0, "成功", null);
            JsonUtil.ReturnJson(resp, result);
            req.getSession().setAttribute("noticeId",id);
        }
    }
}
