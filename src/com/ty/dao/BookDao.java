package com.ty.dao;

import com.ty.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
图书Dao类
 */
public class BookDao {
    /*
    图书添加
     */
    public int add(Connection connection, Book book)throws Exception{
        String sql="insert into t_book values(null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,book.getBookName());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setString(3,book.getSex());
        preparedStatement.setFloat(4,book.getPrice());
        preparedStatement.setInt(5,book.getBookTypeId());
        preparedStatement.setString(6,book.getBookDesc());
        return preparedStatement.executeUpdate();
    }
}
