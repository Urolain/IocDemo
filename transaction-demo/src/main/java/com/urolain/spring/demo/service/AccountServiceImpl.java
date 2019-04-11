package com.urolain.spring.demo.service;

import com.urolain.spring.demo.dao.AccountDaoInterface;

public class AccountServiceImpl implements AccountService {

    private AccountDaoInterface accountDao;

    public void setAccountDao(AccountDaoInterface accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String out, String in, double money) {
        //  一次转账行为包括 1.1 转出账号转出金额 1.2 转入账号转入金额
        accountDao.outMoney(out,money);
        accountDao.inMoney(in,money);
    }
}
