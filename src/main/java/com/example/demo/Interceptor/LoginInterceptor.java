package com.example.demo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null){
            //未登录，返回登录页面
            request.setAttribute("msg","没有权限请先登录");
            try {
                request.getRequestDispatcher("/index.html").forward(request,response);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return false;
        }else {
            //已登录
            return true;
        }
    }


}
