package com.urolain.luckymoeny.service;

import com.urolain.luckymoeny.domain.UserDO;

import java.math.BigDecimal;
import java.util.List;

public interface LuckymoneyService {

    String sendLuckymoney(Long senderUID, BigDecimal money);

    String acceptLuckymoney(Long recipientUID, BigDecimal money);


}
