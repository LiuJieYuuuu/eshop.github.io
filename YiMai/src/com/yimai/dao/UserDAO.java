package com.yimai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yimai.pojo.User;
import com.yimai.util.DBConn;

public class UserDAO {
	/**
	 * 根据用户id查到所有信息
	 * @param id
	 * @return
	 */
	public User getUserInfo(String id) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		User user=new User();
		String sql="select * from easybuy_user where eu_user_id=? ";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			re=pstmt.executeQuery();
			while(re.next()) {
				user.setId(id);
				user.setUsername(re.getString("eu_user_name"));
				user.setPassword(re.getString("eu_password"));
				user.setSex(re.getString("eu_sex"));
				user.setLogin(re.getInt("eu_login"));
				user.setStatus(re.getInt("eu_status"));
				user.setAddress(re.getString("eu_address"));
			}
			return user;
		} catch (Exception e) {
			return null;
		} finally {
			DBConn.Close(re, pstmt, con);
		}
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public boolean registerUser(User user) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into easybuy_user(eu_user_id,eu_password)"
				+ "values(?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2,user.getPassword());
			int a=pstmt.executeUpdate();
			if(a==0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		} finally {
			DBConn.Close(null, pstmt, con);
		}
	}
	/**
	 * 用户登录
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean loginUser(String id,String pwd) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		String sql="select * from easybuy_user where eu_user_id=? and eu_password=? ";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2,pwd);
			re=pstmt.executeQuery();
			if(re.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			DBConn.Close(re, pstmt, con);
		}
	}
}
