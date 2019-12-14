package com.lx.servlet;

import com.lx.POJO.User;
import com.lx.dto.Result;
import com.lx.service.ShareService;
import com.lx.utils.ServletFileUploadUtil;
import com.lx.utils.JsonUtils;
import com.lx.utils.RandomUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/uploadAdminServlet")
public class UploadAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        User user = (User) req.getSession().getAttribute("adminUser");
//        如果Session超时，则不进行文件上传
        if(user==null){
            JsonUtils.returnJson(resp,new Result(1,"登录已超时,请重新登录",null));
        }else{
            try {
//                获取ServletFileUpload
                ServletFileUpload fileUpload = ServletFileUploadUtil.getServletFileUpload();
                List<FileItem> fileItems = fileUpload.parseRequest(req);
                for(FileItem fileItem:fileItems){
//                    如果不为普通表单项，则是文件
                    if(!fileItem.isFormField()){
//                        获取文件名
                        String name = fileItem.getName();
                        System.out.println(name);
                        String randomName = RandomUtil.getStringRandom(4)+name;
//                        文件保存在：项目真实路径/upload文件夹下
                        String webpath = getServletContext().getRealPath("/upload/"+randomName);
                        File file = new File(webpath);
                        if(!file.getParentFile().exists()){
                            file.getParentFile().mkdir();
                        }
                        FileOutputStream fos= new FileOutputStream(file);
                        InputStream fis = fileItem.getInputStream();
                        byte [] buffer = new byte[1024];
                        int len;
                        while((len =fis.read(buffer))!=-1){
                            fos.write(buffer,0,len);
                        }
                        ShareService shareService = context.getBean(ShareService.class);
                        shareService.insertShare(user.getUserName(),randomName,user.getClubId());
                        JsonUtils.returnJson(resp,new Result(0,"成功",null));
                        fis.close();
                        fos.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                JsonUtils.returnJson(resp,new Result(1,"异常",null));
            }
        }
    }
}
