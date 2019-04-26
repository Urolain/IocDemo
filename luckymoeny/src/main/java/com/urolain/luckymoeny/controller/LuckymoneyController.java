package com.urolain.luckymoeny.controller;

import com.urolain.luckymoeny.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckymoneyController {

    @Autowired
    private LimitConfig config;

    @GetMapping("/info")
    public String info(){
        return config.getDescription();
    }
}
