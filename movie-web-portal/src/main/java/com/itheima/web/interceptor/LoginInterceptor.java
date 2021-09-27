package com.itheima.web.interceptor;

import com.itheima.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {

    //进入controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入了拦截器....");

        //先判断当前用户是否登录了,如果没有登录,不能给他返回结果,返回状态码401
        //如果是登录了,继续原来的流程
        try {
            String token = request.getHeader("token");
            Map map = JwtUtil.parseToken(token);

            //解析成功,放行
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}
