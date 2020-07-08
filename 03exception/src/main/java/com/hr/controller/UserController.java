package com.hr.controller;

import com.hr.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring异常处理
 * 1 编写自定义异常类(做提示信息的)
 * 2 编写异常处理器
 * 3 配置异常处理器(跳转到提示页面)
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("testException执行了...");
        try {
            //模拟调用service层出现异常(下层向上层抛, 最终是controller层处理)
            int i = 10/0;
        } catch (Exception e) {
            //controller层捕获异常后,再抛出异常
            e.printStackTrace();
            throw new SysException("查询所有用户出现错误");
        }
        return "success";
    }
}
