import com.urolain.spring.demo.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TransferTest {

    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void transferTest(){
        /*
        ApplicationContext applicationContext =(ApplicationContext) new ClassPathXmlApplicationContext("classpath:application.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountServiceImpl.class);
        */
        accountService.transfer("urolain","dora",20d);
    }

}
