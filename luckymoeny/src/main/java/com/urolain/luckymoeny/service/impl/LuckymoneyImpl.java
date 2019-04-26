package com.urolain.luckymoeny.service.impl;

import com.urolain.luckymoeny.domain.LuckymoneyDO;
import com.urolain.luckymoeny.domain.LuckymoneyDao;
import com.urolain.luckymoeny.domain.UserDO;
import com.urolain.luckymoeny.domain.UserDao;
import com.urolain.luckymoeny.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
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

    @Transactional
    @Override
    public String acceptLuckymoney(Long recipientUID, Long luckmoneyID) {
        //  根据红包ID获取红包记录
        LuckymoneyDO luckymoneyDO = null;
        Optional<LuckymoneyDO> luckymoneyOptional = luckymoneyDao.findById(luckmoneyID);
        if (luckymoneyOptional.isPresent()) {
            luckymoneyDO = luckymoneyOptional.get();
        }

        UserDO recipient = null;
        Optional<UserDO> recipientOptional = userDao.findById(recipientUID);
        if (recipientOptional.isPresent()) {
            recipient = recipientOptional.get();
        }

        if (luckymoneyDO == null || recipient == null ) {
            return "参数有误!请检查!";
        }

        BigDecimal balance = recipient.getBalance();
        //  当前领取者余额增加
        if (balance == null) {
            recipient.setBalance(luckymoneyDO.getMoney());
        }else {
            recipient.setBalance(balance.add(luckymoneyDO.getMoney()));
        }
        //  当前红包记录更新领取者
        luckymoneyDO.setRecipient(recipientUID);

        //  更新用户余额
        userDao.save(recipient);
        //  更新红包记录
        luckymoneyDao.save(luckymoneyDO);
        return recipient.getName()+"领取了"+userDao.getOne(luckymoneyDO.getSender()).getName()+"的红包,金额:"+luckymoneyDO.getMoney();
    }

    @Override
    public List<LuckymoneyDO> getUserSentLuckymoneys(Long senderUID) {

        return luckymoneyDao.findAllBySender(senderUID);
    }
}
