package com.lx.servlet;


import com.lx.POJO.User;
import com.lx.POJO.WorkTime;
import com.lx.dto.Result;
import com.lx.service.WorkTimeService;
import com.lx.utils.DateUtil;
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

@WebServlet("/checkInServlet")
public class CheckInServlet extends HttpServlet {

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
        //判断session是否为空
        if (user ==null){
            Result result = new Result(1,"请重新登录",null);
            JsonUtil.ReturnJson(resp,result);
        }else {
            //获取session userid
            int clubId = user.getClubId();
            int userId = user.getId();
            //判断是否重复日期
            // 插入worktime
            WorkTimeService service = context.getBean(WorkTimeService.class);
            List<Integer> days = service.queryWorkTimeByStAndEt(userId, DateUtil.getStartTime(), DateUtil.getEndTime());
            boolean b = DateUtil.isRepeatDate(days, DateUtil.getDateDay());
            if (b){
                Result result = new Result(0,"今天已签过到，不要重复签到",null);
                JsonUtil.ReturnJson(resp,result);
            }else{
                WorkTime workTime = new WorkTime();
                workTime.setClubId(clubId);
                workTime.setUserId(userId);
                service.insertWorkTime(workTime);
                Result result = new Result(0,"成功",DateUtil.getDateDay());
                JsonUtil.ReturnJson(resp,result);
            }

        }
    }
}
