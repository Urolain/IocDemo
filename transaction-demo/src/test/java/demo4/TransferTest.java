package demo4;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.demo4.AccountService;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application4.xml")
public class TransferTest {

    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void transferTest(){
        accountService.jdbcTransfer("urolain","dora",20d);
    }

}
