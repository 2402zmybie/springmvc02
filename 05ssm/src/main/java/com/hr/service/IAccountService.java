package com.hr.service;

import com.hr.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    void saveAccount(Account account);
}
