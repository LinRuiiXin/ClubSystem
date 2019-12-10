package com.lx.servlet;

import com.lx.POJO.IndexInfo;
import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.LoadIndexService;
import com.lx.utils.JsonUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loadIndexServlet")
public class LoadIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        if(user == null){
            JsonUtils.returnJson(resp,new Result(1,"登录超时,请重新登录",null));
        }else{
            ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
            LoadIndexService loadIndexService = context.getBean(LoadIndexService.class);
            IndexInfo indexInfo = loadIndexService.getIndexInfo(user);
            JsonUtils.returnJson(resp,new Result(0,"成功",indexInfo));
        }
    }
}
