package com.lx.servlet;

import com.lx.POJO.Share;
import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.ShareService;
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

@WebServlet("/loadAdminShareServlet")
public class LoadAdminShareServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        User user = (User) req.getSession().getAttribute("adminUser");
        if(user==null){
            JsonUtils.returnJson(resp,new Result(1,"登陆超时，请重新登录",null));
        }else{
            ShareService shareService = context.getBean(ShareService.class);
            List<Share> shares = shareService.queryByClubId(user.getClubId());
            JsonUtils.returnJson(resp,new Result(0,"成功",shares));
        }
    }
}
