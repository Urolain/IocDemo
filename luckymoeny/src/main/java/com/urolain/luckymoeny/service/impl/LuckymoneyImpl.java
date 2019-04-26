package com.urolain.luckymoeny.service.impl;

import com.urolain.luckymoeny.domain.LuckymoneyDO;
import com.urolain.luckymoeny.domain.LuckymoneyDao;
import com.urolain.luckymoeny.domain.UserDO;
import com.urolain.luckymoeny.domain.UserDao;
import com.urolain.luckymoeny.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
@Service
public class LuckymoneyImpl implements LuckymoneyService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LuckymoneyDao luckymoneyDao;



    @Override
    public String sendLuckymoney(Long senderUID, BigDecimal money) {
        UserDO sender = null;
        Optional<UserDO> senderOptional = userDao.findById(senderUID);
        if (senderOptional.isPresent()){
            sender = senderOptional.get();
            BigDecimal balance = sender.getBalance();
            if (balance == null || balance.compareTo(money) == -1) {
                return sender.getName()+"当前账户余额不足,无法进行本次红包发放";
            }
            //  当前用户扣款
            sender.setBalance(balance.subtract(money));
            LuckymoneyDO luckymoneyDO = new LuckymoneyDO();
            luckymoneyDO.setMoney(money);
            luckymoneyDO.setSender(senderUID);
            userDao.save(sender);
            luckymoneyDao.save(luckymoneyDO);
            return sender.getName()+"成功发出"+money+"元红包!";
        }else {
            return "无法找到该用户!";
        }
    }

    @Override
    public String acceptLuckymoney(Long recipientUID, BigDecimal money) {
        return null;
    }
}
