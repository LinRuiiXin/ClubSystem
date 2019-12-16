package com.lx.servlet;

import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.WorkTimeService;
import com.lx.utils.DateUtil;
import com.lx.utils.JsonUtil;
import com.lx.utils.JsonUtils;
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

@WebServlet("/loadCheckInServlet")
public class LoadCheckInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user == null){
            Result result = new Result(1,"登录超时，请重新登陆",null);
            JsonUtil.ReturnJson(resp,result);
        }else{
            WorkTimeService service = context.getBean(WorkTimeService.class);
            List<Integer> days = service.queryWorkTimeByIdStEt(user.getId(), DateUtil.getStartDate(), DateUtil.getEndDate());
            Result result = new Result(0,"成功",days);
            JsonUtil.ReturnJson(resp,result);
        }
    }
}
