package com.hr.test;

import com.hr.dao.IAccountDao;
import com.hr.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws IOException {
//        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
//        //创建SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        //创建SqlSession对象
//        SqlSession session = sqlSessionFactory.openSession();
//        IAccountDao dao = session.getMapper(IAccountDao.class);
//        List<Account> accounts = dao.findAll();
//        for(Account a : accounts) {
//            System.out.println(a);
//        }
//        session.close();
//        in.close();
    }


    @Test
    public void run2() throws IOException {
//        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
//        //创建SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        //创建SqlSession对象
//        SqlSession session = sqlSessionFactory.openSession();
//        IAccountDao dao = session.getMapper(IAccountDao.class);
//        Account account = new Account();
//        account.setName("蝈蝈");
//        account.setMoney(1d);
//        dao.saveAccount(account);
//        session.commit();
//        session.close();
//        in.close();
    }
}
