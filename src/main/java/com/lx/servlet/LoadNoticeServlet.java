package com.lx.servlet;

import com.lx.POJO.Notice;
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
import java.util.List;

@WebServlet("/loadNoticeServlet")
public class LoadNoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        String noticeId = (String) req.getSession().getAttribute("noticeId");
        NoticeService noticeService = context.getBean(NoticeService.class);
        if (noticeId==null){
            Result result = new Result(1,"找不到记录",null);
            JsonUtil.ReturnJson(resp,result);
        }else {
            List<Notice> noticeList = noticeService.queryAllById(Integer.parseInt(noticeId));
            Result result = new Result(0,"成功",noticeList);
            JsonUtil.ReturnJson(resp,result);
        }
        //获取session中的noticeid
        //根据noticeid来查找notice
    }
}
