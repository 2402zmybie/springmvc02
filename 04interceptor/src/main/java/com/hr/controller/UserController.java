package com.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 过滤器: servlet规范中的一部分,任何java web工程都可以使用
 * 拦截器: springMVC框架自己的,只有使用了SpringMVC框架才可以使用
 * 过滤器: 是在url-pattern中配置了/*之后,可以对所有要访问的资源拦截
 * 拦截器: 它是只会拦截访问的控制器方法,如果访问的是jsp,html,css,image或者js是不会进行拦截的,它也是AOP思想的具体应用
 * 我们要想自定义拦截器,要求必须实现 HandlerInterceptor接口
 *
 * 自定义拦截器步骤:
 * 1 编写拦截器类
 * 2 配置拦截器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor执行了...");
        return "success";
    }
}
