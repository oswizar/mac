package com.xiexing.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiexing.entity.Stu;
import com.xiexing.service.IStuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class StuController {


    @Resource
    private IStuService stuService;

    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 用户注册
     *
     * @param registUser
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/showUser", produces = "application/json;charset=utf-8")
    public Object postUser(@RequestBody Stu registUser) throws IOException {
        Map<String, Object> msg = new HashMap<>();
        try {
            Stu user = stuService.selectUserByName(registUser.getName());
            if (user != null) {
                msg.put("msg", "账号已被注册");
                return msg;
            } else {
                boolean flag = stuService.addUser(registUser);
                System.out.println(flag);
                if (flag) {
                    msg.put("msg", "注册成功");
                    return msg;
                } else {
                    msg.put("msg", "注册失败");
                    return msg;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("msg", "网络故障");
            return msg;
        }


    }

    /**
     * 用户登录
     *
     * @param loginUser
     * @return
     */
    @RequestMapping(value = "/loginUser", produces = "application/json;charset=utf-8")
    public Object loginUser(@RequestBody Stu loginUser) {
        Map<String, Object> msg = new HashMap<>();
        try {
            Stu user = stuService.selectUserByName(loginUser.getName());
            System.out.println(user);

            if (user == null) {
                msg.put("msg", "账号不存在");
                return msg;
            } else if (!(user.getPassword().equals(loginUser.getPassword()))) {
                msg.put("msg", "密码错误");
                return msg;
            } else {
                msg.put("msg", "登录成功");
                msg.put("user", user);
                return msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("msg", "网络故障");
            return msg;
        }

    }


    /**
     * 用户信息修改
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser", produces = "application/json;charset=utf-8")
    public Object updateUser(@RequestBody Stu user) {
        Map<String, Object> msg = new HashMap<>();
        try {
            boolean flag = stuService.modifyUser(user);
            if (flag) {
                msg.put("msg", "修改成功");
                return msg;
            } else {
                msg.put("msg", "修改失败");
                return msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("msg", "网络故障");
            return msg;
        }

    }

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/removeUser", produces = "application/json;charset=utf-8")
    public Object removeUser(@RequestBody Stu user) {
        Map<String, Object> msg = new HashMap<>();
        try {
            int id = user.getId();
            boolean flag = stuService.removeUser(id);
            if (flag) {
                msg.put("msg", "删除成功");
                return msg;
            } else {
                msg.put("msg", "删除失败");
                return msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("msg", "网络故障");
            return msg;
        }

    }

    /**
     * 查询用户接口测试
     *
     * @return
     */
    @RequestMapping(value = "/allUser", produces = "application/json;charset=utf-8")
    public Object allUser() {
        Map<String, Object> msg = new HashMap<>();
        try {
            List<Stu> list = stuService.selectAllUser();
            if (list.size() > 0) {
                msg.put("list", list);
                return msg;
            } else {
                msg.put("msg", "没有查询到数据");
                return msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("msg", "网络故障");
            return msg;
        }

    }
}
