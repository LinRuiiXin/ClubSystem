package com.lx.servlet;

import com.alibaba.fastjson.JSON;
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

@WebServlet("/agreeApplyServlet")
public class AgreeApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("adminUser");
        if(user == null){
            JsonUtils.returnJson(resp,new Result(1,"登录超时，请重新登录",null));
        }else{
            req.setCharacterEncoding("UTF-8");
            String applyId = req.getParameter("applyId");
            ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
            ApplyService applyService = context.getBean(ApplyService.class);
            if(applyService.isLastOne(Integer.parseInt(applyId))){
                applyService.handleLastApply(Integer.parseInt(applyId));
            }else{
                applyService.insertToApplyBuffer(Integer.parseInt(applyId),user.getId());
            }
            JsonUtils.returnJson(resp,new Result(0,"成功",null));
        }
    }
}
