package demo3;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.demo3.AccountService;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application3.xml")
public class TransferDemo3Test {

    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void transferTest(){

        accountService.transfer("urolain","dora",20d);
    }

}
