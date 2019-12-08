package com.lx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletRequest myRequset = new MyRequest(httpServletRequest);
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(myRequset, servletResponse);
    }

    @Override
    public void destroy() {

    }
    class MyRequest extends HttpServletRequestWrapper {private HttpServletRequest request;
        private boolean hasEncode;
        public MyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }
        @Override
        public Map getParameterMap() {
            String method = request.getMethod();
            if(method.equalsIgnoreCase("post")) {
                try {
                    request.setCharacterEncoding("utf-8");
                    return request.getParameterMap();
                }catch(UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if(method.equalsIgnoreCase("get")) {
                Map<String,String[]> parameterMap = request.getParameterMap();
                if(!hasEncode) {
                    for(String parameterName:parameterMap.keySet()) {
                        String [] values = parameterMap.get(parameterName);
                        if(values != null) {
                            for(int i=0;i<values.length;i++) {
							/*
							try {
								values[i] = new String(values[i].getBytes("ISO-8859-1"),"utf-8");
							}catch(UnsupportedEncodingException e) {
								e.printStackTrace();
							}
							*/
                                values[i] = new String(values[i]);
                            }
                        }
                    }
                    hasEncode = true;
                }
                return parameterMap;
            }
            return super.getParameterMap();
        }
    }
}
