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
import java.io.IOException;

@WebServlet("/insertNoticeServlet")
public class InsertNoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        User user = (User) req.getSession().getAttribute("adminUser");
        NoticeService noticeService = context.getBean(NoticeService.class);
        //判断session中是否有数据
        if(user==null){
            Result result = new Result(1,"登陆超时，请重新登陆",null);
            JsonUtil.ReturnJson(resp,result);
        }else{
            int clubId = user.getClubId();
            String userName = user.getUserName();
            String title = req.getParameter("title");
            String message = req.getParameter("message");
            Notice notice = new Notice();
            notice.setClubId(clubId);
            notice.setMessage(message);
            notice.setTitle(title);
            notice.setReleaseName(userName);
            noticeService.insertNotice(notice);
            Result result = new Result(0,"成功",null);
            JsonUtil.ReturnJson(resp,result);
        }
        //获取session中user的clubid
        //将task插入数据库
    }
}
