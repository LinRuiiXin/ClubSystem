package com.lx.servlet;

import com.lx.POJO.Task;
import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.TaskService;
import com.lx.service.UserService;
import com.lx.utils.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insertTaskServlet")
public class InsertTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        User user = (User) req.getSession().getAttribute("adminUser");
        TaskService taskService = context.getBean(TaskService.class);
        UserService userService = context.getBean(UserService.class);
        //判断session是否为空
        //获取userid 和 task
        //releaseName  title  message  touserid
        if (user==null){
            Result result = new Result(1,"登陆超时，请重新登陆",null);
            JsonUtil.ReturnJson(resp,result);
        }else{
            String userName = user.getUserName();
            String title = req.getParameter("title");
            String message = req.getParameter("message");
            String releaseName = req.getParameter("releaseName");
            int userId = userService.queryIdByUserName(releaseName);
            Task task = new Task();
            task.setTitle(title);
            task.setMessage(message);
            task.setUserId(userId);
            task.setReleaseName(userName);
            taskService.insertTask(task);
            System.out.println(task);
            Result result = new Result(0,"成功",null);
            JsonUtil.ReturnJson(resp,result);
        }
    }
}
