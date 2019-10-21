package com.ty.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ty.model.BookType;
import com.ty.util.StringUtil;


/**
 * ͼ�����Dao��
 * @author 23981
 *
 */
public class BookTypeDao {
	/**
	 * ͼ��������
	 * @param connection
	 * @param //bookTypeDao
	 * @return
	 * @throws Exception
	 */
	public int add(Connection connection,BookType bookType)throws Exception{
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement prepareStatement=connection.prepareStatement(sql);
		prepareStatement.setString(1,bookType.getBookTypeName());
		prepareStatement.setString(2, bookType.getBookTypeDesc());
		return prepareStatement.executeUpdate();
	}
	/*
	��ѯͼ����𼯺�
	 */
	public ResultSet list(Connection connection,BookType bookType)throws Exception{
		StringBuffer stringBuffer = new StringBuffer("select * from t_bookType");
		if (StringUtil.isNotEmpty(bookType.getBookTypeName())){
			stringBuffer.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement prepareStatement=connection.prepareStatement(stringBuffer.toString().replaceFirst("and","where"));
		return prepareStatement.executeQuery();
	}

	/*
	ɾ��ͼ�����
	 */
	public int delete(Connection connection,String id)throws Exception{
	    String sql="delete from t_bookType where id=?";
	    PreparedStatement prepareStatement=connection.prepareStatement(sql);
	    prepareStatement.setString(1,id);
	    return prepareStatement.executeUpdate();
    }

    /*
    ����ͼ�����
     */
    public int update(Connection connection,BookType bookType)throws Exception{
        String sql="update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,bookType.getBookTypeName());
        preparedStatement.setString(2,bookType.getBookTypeDesc());
        preparedStatement.setInt(3,bookType.getId());
        return preparedStatement.executeUpdate();
    }

}
