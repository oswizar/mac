package com.xiexing.dao;

import com.xiexing.entity.Stu;

import java.util.List;

public interface StuMapper {

    Stu selectUser(int id);

    List<Stu> selectAllUser();

    int addUser(Stu stu);

    int removeUser(int id);

    int modifyUser(Stu stu);

    Stu selectUserByName(String name);
}