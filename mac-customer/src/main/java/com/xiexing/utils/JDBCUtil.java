/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: JDBCUtil
 * Author:   xiexing
 * Date:     2018/12/12 10:03
 * Description: 数据库连接检测
 */
package com.xiexing.utils;

import org.junit.Test;

import java.sql.*;

public class JDBCUtil {

    @Test
    public void JDBCTest() {
        String username = "xiexing";
        String password = "xiexing";
        String url = "jdbc:mysql://10.10.10.96:3306/test?useUnicode=true&characterEncoding=utf-8";
        String driver = "com.mysql.jdbc.Driver";
        // 一个封装了TCP长连接的数据库长连接对象
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("连接数据库成功!!!");

        } catch (Exception e) {
            System.out.println("连接数据库发生异常!!!");
            //e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("数据库连接对象已正常关闭!!!");
                } catch (SQLException e) {
                    System.out.println("数据库连接对象关闭发生异常!!!");
                    //e.printStackTrace();
                }
            }

        }
    }
}
