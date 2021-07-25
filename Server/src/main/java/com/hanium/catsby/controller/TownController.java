package com.hanium.catsby.controller;

import com.hanium.catsby.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TownController {

    @Autowired
    TownService townService;

    @GetMapping("/townCommunity")//우리동네고양이 메인
    public String town(){
        return "테스트 완료";
    }



}
