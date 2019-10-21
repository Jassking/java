package com.ty.dao;

import com.ty.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
用户Dao类
 */
public class UserDao {
    //登陆验证
    public User login(Connection connection, User user) throws Exception {
        User resultUser = null;
        String sql = "select*from t_user where userName=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            resultUser = new User();
            resultUser.setId(resultSet.getInt("id"));
            resultUser.setUserName(resultUser.getString("userName"));
            resultUser.setPassword(resultUser.getString("password"));
        }
        return resultUser;
    }
}
