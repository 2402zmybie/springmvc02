package com.hr.controller;

import com.hr.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(ModelMap modelMap) {
        System.out.println("testString....");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("老何");
        user.setPassword("123");
        user.setAge(27);
        //model存对象到request域中
        modelMap.addAttribute("user",user);
        return "success";
    }


    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid....");
        //转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        //直接对浏览器进行响应要输出的内容
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("对浏览器输出");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView....");
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("老何");
        user.setPassword("123");
        user.setAge(27);
        //把user对象存入mv中, 同时也会把user对象存入到request域对象中
        mv.addObject("user",user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方法进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect....");
        //转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟ajax请求
     */
    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body) {
        System.out.println("testAjax....");
        System.out.println(body);
    }
}
