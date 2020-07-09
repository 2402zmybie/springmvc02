package com.hr.controller;

import com.hr.domain.Account;
import com.hr.exception.MyException;
import com.hr.service.IAccountService;
import com.hr.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(ModelMap modelMap) {
        System.out.println("表现层查询所有的账户信息");
        //调用service方法
        List<Account> accounts = accountService.findAll();
        modelMap.addAttribute("accounts",accounts);
        return "list";
    }

    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws MyException {
        try {
            accountService.saveAccount(account);
            //模拟调用service层出现异常(下层向上层抛, 最终是controller层处理)
//            int i = 10 /0;
            //重定向
            response.sendRedirect(request.getContextPath() + "/account/findAll");
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("请联系管理员");
        }


    }
}
