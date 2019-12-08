package com.lx.servlet;

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
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/downLoadFileServlet")
public class DownLoadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        URLDecoder.decode(req.getParameter("fileName"),"UTF-8");
        String fileName = req.getParameter("fileName");
        System.out.println(fileName);
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        String filePath = getServletContext().getRealPath("/upload/"+fileName);
        System.out.println(fileName);
        File file = new File(filePath);
        if(!file.exists()){
            JsonUtils.returnJson(resp,new Result(1,"抱歉！文件已丢失",null));
            ShareService shareService = context.getBean(ShareService.class);
            shareService.deleteLostFile(fileName);
        }else{
            resp.addHeader("Content-Type","application/octet-stream");
            resp.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName.substring(4,fileName.length()),"UTF-8"));
            InputStream fis = new FileInputStream(file);
            OutputStream fos = resp.getOutputStream();
            byte [] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
//            JsonUtils.returnJson(resp,new Result(0,"成功",null));
            fis.close();
            fos.close();
        }
    }
}
