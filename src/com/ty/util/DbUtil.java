package com.ty.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
���ݿ⹤����
 */
public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8";//���ݿ����ӵ�ַ
    private String dbUserName = "root";//�û���
    private String dbPassword = "root";//����
    private String jdbcName = "com.mysql.jdbc.Driver";//��������

    /*
    ��ȡ���ݿ�����
     */
    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return connection;
    }

    /*
    �ر����ݿ�����
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
            System.out.println("���ݿ����ӳɹ���");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ�ܣ�");
        }

    }
}