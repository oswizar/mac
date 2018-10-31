package com.xiexing.runner;

import java.io.IOException;

public class ProviderRunner {
    /**
     * 启动类
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        /**
         * 本地调试启动,只能把服务和接口直接放入dubbo容器
         */
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                new String[] { "provider.xml" });
//        context.start();
//        System.in.read();

        /**
         * 从spring容器启动，自动加载META-INF/spring内的配置文件(如果没有该文件夹需要手动创建)
         */
        com.alibaba.dubbo.container.Main.main(args);
    }
}