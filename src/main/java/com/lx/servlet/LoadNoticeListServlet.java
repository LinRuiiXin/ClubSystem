package com.lx.servlet;

import com.lx.POJO.Notice;
import com.lx.POJO.User;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/loadNoticeListServlet")
public class LoadNoticeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("adminUser");
        //判断session中有无数据，有就获取，没有就返回重新登陆
        if (user==null){
            Result result = new Result(1,"登陆超时，请重新登陆",null);
            JsonUtil.ReturnJson(resp,result);
        }else {
            NoticeService service = context.getBean(NoticeService.class);
            List<Notice> notices = service.queryAllByClubId(user.getClubId());
            Result result = new Result(0,"成功",notices);
            JsonUtil.ReturnJson(resp,result);
        }

    }
}
