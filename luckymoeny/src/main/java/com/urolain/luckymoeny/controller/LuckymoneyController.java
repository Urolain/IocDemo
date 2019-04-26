package com.urolain.luckymoeny.controller;

import com.urolain.luckymoeny.config.LimitConfig;
import com.urolain.luckymoeny.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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

    @GetMapping("/send")
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


}
