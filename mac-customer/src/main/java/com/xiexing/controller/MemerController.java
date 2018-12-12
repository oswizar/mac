/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: MemerController
 * Author:   xiexing
 * Date:     2018/12/7 16:50
 * Description:
 */
package com.xiexing.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiexing.service.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemerController {

    @Reference
    IMemberService memberService;

    @RequestMapping("/print")
    public String print(String name){
        String print = memberService.print(name);
        return print;
    }
}
