package com.dbd.seoulcinema.global.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("adminId") == null) {
            //로그인으로 redirect
            response.sendRedirect("/admin/login?redirectURL=" + requestURI); return false;
        }
        return true;
    }
}
