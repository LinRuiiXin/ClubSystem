package com.lx.servlet;

import com.alibaba.fastjson.JSON;
import com.lx.POJO.Task;
import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.TaskService;
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

@WebServlet("/loadTaskServlet")
public class LoadTaskServlet extends HttpServlet {
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
        //判断session中的数据是否为空
        if (user==null){
            Result result = new Result(1,"登陆超时，请重新登陆",null);
            JsonUtil.ReturnJson(resp,result);
        }else {
            TaskService service = context.getBean(TaskService.class);
            List<Task> tasks = service.queryAllByUserId(user.getId());
            Result result = new Result(0,"成功",tasks);
            JsonUtil.ReturnJson(resp,result);
        }
        //
    }
}
