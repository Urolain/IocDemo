package com.urolain.luckymoeny.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckymoneyDaoTest {

    @Autowired
    private LuckymoneyDao luckymoneyDao;


    @Test
    public void test() {
        LuckymoneyDO luckymoneyDO = new LuckymoneyDO();
        luckymoneyDO.setSender(1L);
        luckymoneyDO.setMoney(new BigDecimal("200"));
        luckymoneyDao.save(luckymoneyDO);
        luckymoneyDO.setSender(3L);
        luckymoneyDO.setMoney(new BigDecimal("188"));
        luckymoneyDO.setRecipient(1L);
        luckymoneyDao.save(luckymoneyDO);
    }
}
