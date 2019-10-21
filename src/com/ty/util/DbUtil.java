package com.ty.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
数据库工具类
 */
public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";//数据库链接地址
    private String dbUserName = "root";//用户名
    private String dbPassword = "root";//密码
    private String jdbcName = "com.mysql.jdbc.Driver";//驱动名称

    /*
    获取数据库连接
     */
    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return connection;
    }

    /*
    关闭数据库连接
     */
    public void closeConnection(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        DbUtil DbUtil = new DbUtil();
        try {
            DbUtil.getCon();
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }

    }
}