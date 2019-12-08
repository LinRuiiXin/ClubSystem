package com.lx.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JsonUtils {
    public static void returnJson(HttpServletResponse response,Object o){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        //禁用缓存，确保网页信息是最新数据
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", -10);
        PrintWriter writer = null;
        try{
            writer = response.getWriter();
            String s = JSON.toJSONString(o);
            writer.write(s);
            System.out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
