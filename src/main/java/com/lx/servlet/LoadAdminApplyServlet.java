package com.lx.servlet;

import com.lx.POJO.Apply;
import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.ApplyService;
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

@WebServlet("/loadAdminApplyServlet")
public class LoadAdminApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("adminUser");
        if(user == null){
            JsonUtils.returnJson(resp,new Result(1,"登陆超时，请重新登录",null));
        }else{
            ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
            ApplyService applyService = context.getBean(ApplyService.class);
            List<Apply> applyList = applyService.queryRemApplyByClubIdAndAdminId(user.getClubId(), user.getId());
            JsonUtils.returnJson(resp,new Result(0,"成功",applyList));
        }
    }
}
