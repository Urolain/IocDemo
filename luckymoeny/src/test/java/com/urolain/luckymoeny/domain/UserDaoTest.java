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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void test(){
        UserDO user = new UserDO();
        user.setId(1L);
        user.setName("风清扬");
        user.setBalance(BigDecimal.valueOf(2000));

        UserDO user2 = new UserDO();
        user2.setId(2L);
        user2.setName("龙傲天");
        user2.setBalance(BigDecimal.valueOf(100));

        UserDO user3 = new UserDO();
        user3.setId(3L);
        user3.setName("杨过");
        user3.setBalance(BigDecimal.valueOf(6852));

        userDao.save(user);
        userDao.save(user2);
        userDao.save(user3);
    }
}
