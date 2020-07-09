package com.hr.service.impl;

import com.hr.dao.IAccountDao;
import com.hr.domain.Account;
import com.hr.exception.MyException;
import com.hr.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询所有的账户信息");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层保存账户");
        //模拟业务层出现异常 (事务管理)
//        int i = 10 /0;
        accountDao.saveAccount(account);
    }
}
