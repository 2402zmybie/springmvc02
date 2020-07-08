package com.hr.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptpr implements HandlerInterceptor {

    /**
     * 预处理, controller方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return true 放行, 执行下一个拦截器,如果没有,就执行controller中的方法
     *          false不放行,controller中方法都不能执行, 可以用request或者response跳转到其他页面或者做拦截处理(权限)
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptpr  preHandle执行了...");
        //return false 拦截请求,跳转到登录页面
//        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);
//        return false;
        return true;
    }

    /**
     * 后处理方法 controller方法执行之后, success.jsp执行之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptpr postHandle...(执行之后)");
        //controller执行之后,可以不跳controller规定的页面, 可跳转到下面配置的页面
//        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request,response);

    }

    /**
     * jsp方法执行后, 该方法执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptpr afterCompletion...(最后)");
    }
}
