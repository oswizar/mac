package com.xiexing.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiexing.service.IUserService;

@Service
public class UserService  implements IUserService{
    @Override
    public String print(String name) {
        return name;
    }
}
