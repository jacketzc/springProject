package com.jacketzc.service;

import com.jacketzc.dao.AccountDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Transactional
public class AccountServiceImpl3 implements AccountService{
    private AccountDao dao;

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }


    /**
     * 转账
     * @param outer 转出账号
     * @param inner 转入账号
     * @param money 金额
     */
    public void transfer(String outer,String inner,Integer money){

        //扣钱
        dao.out(outer,money);
//        int i=10/0;
//        出现异常，事务回滚
        //进账
        dao.in(inner,money);

    }
}
