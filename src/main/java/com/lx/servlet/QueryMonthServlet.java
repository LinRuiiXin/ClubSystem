package com.lx.servlet;

import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.WorkTimeService;
import com.lx.utils.DateUtil;
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
import java.util.Map;

@WebServlet("/queryMonthServlet")
public class QueryMonthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User)req.getSession().getAttribute("User");
        if(user == null){
            JsonUtils.returnJson(resp,new Result(1,"登录超时，请重新登录",null));
        }else{
            ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
            int month = Integer.valueOf(req.getParameter("month"));
            Map<String, String> startAndEndDateByMonth = DateUtil.getStartAndEndDateByMonth(month);
            String startDate = startAndEndDateByMonth.get("startDate");
            String endDate = startAndEndDateByMonth.get("endDate");
            WorkTimeService workTimeService = context.getBean(WorkTimeService.class);
            List<Integer> days = workTimeService.queryWorkTimeByIdStEt(user.getId(), startDate, endDate);
            JsonUtils.returnJson(resp,new Result(0,"成功",days));
        }
    }
}
