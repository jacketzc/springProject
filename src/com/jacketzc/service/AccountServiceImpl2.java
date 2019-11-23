package com.jacketzc.service;

import com.jacketzc.dao.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl2 implements AccountService{
    private AccountDao dao;
//    private TransactionTemplate template;

    //提供set方法让spring注入
    public void setDao(AccountDao dao) {
        this.dao = dao;
    }

//    public void setTemplate(TransactionTemplate template) {
//        this.template = template;
//    }

    /**
     * 转账
     * @param outer 转出账号
     * @param inner 转入账号
     * @param money 金额
     */
    public void transer(String outer,String inner,Integer money){
        /*template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //扣钱
                dao.out(outer,money);
                //进账
                dao.in(inner,money);
            }
        });*/
        //扣钱
        dao.out(outer,money);
        //进账
        dao.in(inner,money);

    }
}
