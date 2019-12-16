package com.lx.servlet;

import com.lx.dto.Result;
import com.lx.service.NoticeService;
import com.lx.utils.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteNoticeServlet")
public class DeleteNoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        //判断req中的id是否为空
        String id = req.getParameter("id");
        System.out.println(id);
        NoticeService noticeService = context.getBean(NoticeService.class);
        if (id==null){
            Result result = new Result(1,"出问题了",null);
            JsonUtil.ReturnJson(resp,result);
        }else {
            noticeService.deleteNoticeById(Integer.parseInt(id));
            Result result = new Result(0,"成功",null);
            JsonUtil.ReturnJson(resp,result);
        }
        //根据id删除notice
    }
}
