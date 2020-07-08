package com.hr.controller;

import com.hr.domain.Account;
import com.hr.service.IAccountService;
import com.hr.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
