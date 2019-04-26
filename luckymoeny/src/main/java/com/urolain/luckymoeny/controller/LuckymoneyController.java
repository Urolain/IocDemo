package com.urolain.luckymoeny.controller;

import com.alibaba.fastjson.JSONArray;
import com.urolain.luckymoeny.config.LimitConfig;
import com.urolain.luckymoeny.domain.LuckymoneyDO;
import com.urolain.luckymoeny.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LuckymoneyController {

    @Autowired
    private LimitConfig config;

    @Autowired
    private LuckymoneyService luckymoneyService;

    @GetMapping("/info")
    public String info(){
        return config.getDescription();
    }

    /**
     * 发红包
     * @param id
     * @param money
     * @return
     */
    @PostMapping("/send")
    public String sendLuckmoney(@RequestParam(name = "id",required = false,defaultValue = "0") Long id,
                                @RequestParam(name = "money",required = false,defaultValue = "0") BigDecimal money ) {
        if (id == 0) {
            return "请输入正确的userid";
        }

        if (money == null) {
            return "请输入正确的金额,说明:"+config.getDescription();
        }

        return luckymoneyService.sendLuckymoney(id,money);
    }

    /**
     * 获取历史红包发送记录
     * /luckymoney/{id}
     * @param id
     * @return
     */
    @GetMapping("/luckymoney/{id}")
    public String getLuckymoneyListById(@PathVariable(value = "id") Long id) {
        List<LuckymoneyDO> result = luckymoneyService.getUserSentLuckymoneys(id);
        if (result != null) {
            return JSONArray.toJSONString(result);
        }else {
            return "无历史红包发放记录";
        }
    }

    /**
     * 领取红包
     * /luckymoney?id=&luckymoneyID
     * @param recipientUID
     * @param luckymoneyID
     * @return
     */
    @PutMapping("/luckymoney")
    public String receiptMoney(@RequestParam(name = "id") Long recipientUID,@RequestParam(name = "luckymoneyID") Long luckymoneyID) {
        return luckymoneyService.acceptLuckymoney(recipientUID,luckymoneyID);
    }




}
