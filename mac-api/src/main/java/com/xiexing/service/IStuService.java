package com.xiexing.service;

import com.xiexing.entity.Stu;

import java.util.List;

public interface IStuService {

    Stu selectUser(int id);

    List<Stu> selectAllUser();

    boolean addUser(Stu stu);

    boolean removeUser(int id);

    boolean modifyUser(Stu stu);

    Stu selectUserByName(String name);

}
