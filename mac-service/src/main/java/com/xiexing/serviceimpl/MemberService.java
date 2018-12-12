/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: IMemberService
 * Author:   xiexing
 * Date:     2018/12/7 16:49
 * Description:
 */
package com.xiexing.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiexing.service.IMemberService;

@Service
public class MemberService implements IMemberService {

    @Override
    public String print(String name) {
        System.out.println(name);
        return name;
    }
}
