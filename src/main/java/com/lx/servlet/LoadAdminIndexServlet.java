package com.lx.servlet;

import com.lx.POJO.AdminIndexInfo;
import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.LoadAdminIndexService;
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

@WebServlet("/loadAdminIndexServlet")
public class LoadAdminIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User adminUser = (User) req.getSession().getAttribute("adminUser");
        if(adminUser == null){
            JsonUtils.returnJson(resp,new Result(1,"登录已超时，请重新登录",null));
        }else{
            ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
            LoadAdminIndexService adminIndexService = context.getBean(LoadAdminIndexService.class);
            AdminIndexInfo adminIndexInfo = adminIndexService.getAdminIndexInfo(adminUser);
            JsonUtils.returnJson(resp,new Result(0,"成功",adminIndexInfo));
        }
    }
}
