package demo2;


import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountDaoInterface accountDao;

    public void setAccountDao(AccountDaoInterface accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public void transfer(String out, String in, double money) {
        //  一次转账行为包括 1.1 转出账号转出金额 1.2 转入账号转入金额
        accountDao.outMoney(out,money);
        //  不使用事务控制的话，一旦中间出现异常，转账场景极有可能出现数据错乱
        //  使用事务控制，要么一起成功，要么一起失败，不会出现数据错乱
        int i = 1/0 ;
        accountDao.inMoney(in,money);
    }
}
