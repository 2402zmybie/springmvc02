package com.hr.test;

import com.hr.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountServiceImpl accountService = classPathXmlApplicationContext.getBean("accountService", AccountServiceImpl.class);
        accountService.findAll();
    }
}
