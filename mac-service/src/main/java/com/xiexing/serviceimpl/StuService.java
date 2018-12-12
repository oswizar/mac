package com.xiexing.serviceimpl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.xiexing.entity.Stu;
import com.xiexing.service.IStuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xiexing.dao.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuService implements IStuService {


    @Autowired

//    @Resource

    private StuMapper stuMapper;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Stu selectUser(int id) {
        return stuMapper.selectUser(id);
    }

    /**
     * 用户查询测试
     *
     * @return
     */
    @Override
    public List<Stu> selectAllUser() {
        return stuMapper.selectAllUser();
    }

    /**
     * 用户注册
     *
     * @param stu
     * @return
     */
    @Override
    public boolean addUser(Stu stu) {
        boolean flag = false;
        try {
            int i = stuMapper.addUser(stu);
            if (i > 0) {
                flag = true;
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return flag;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @Override
    public boolean removeUser(int id) {
        boolean flag = false;
        int i = stuMapper.removeUser(id);
        if (i > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 用户信息修改
     *
     * @param stu
     * @return
     */
    @Override
    public boolean modifyUser(Stu stu) {
        boolean flag = false;
        int i = stuMapper.modifyUser(stu);
        if (i > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 根据账户查询
     *
     * @param name
     * @return
     */
    @Override
    public Stu selectUserByName(String name) {
        Stu stu = stuMapper.selectUserByName(name);
        if (stu != null) {
            log.info("根据账号名称查询User表返回数据",stu);
        }
        log.info("根据账号名称查询User表返回数据",stu);
        return stu;
    }
}
