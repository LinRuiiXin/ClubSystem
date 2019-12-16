package com.lx.utils;


import com.alibaba.fastjson.JSON;
import com.lx.dto.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class JsonUtil {



    public static void ReturnJson(HttpServletResponse response, Result result){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer;
        try {
            writer = response.getWriter();
            String s = JSON.toJSONString(result);
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
