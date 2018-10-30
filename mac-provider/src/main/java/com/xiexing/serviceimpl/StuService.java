package com.xiexing.serviceimpl;

import com.xiexing.dao.StuMapper;
import com.xiexing.entity.Stu;
import com.xiexing.service.IStuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stuService")
public class StuService implements IStuService {

    @Resource
    private StuMapper stuMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Stu selectUser(int id) {
        return stuMapper.selectUser(id);
    }

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
            logger.info(e.getMessage());
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
     * 用户查询测试
     *
     * @param name
     * @return
     */
    @Override
    public Stu selectUserByName(String name) {
        return stuMapper.selectUserByName(name);
    }
}
