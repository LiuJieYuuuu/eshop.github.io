package com.yimai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yimai.util.DBConn;

public class ShoppingDAO {
	/**
	 * 添加商品到购物车
	 * @param userid用户id
	 * @param ep_id商品id
	 * @param number商品数量
	 * @return
	 */
	public boolean addProduct(String userid,int ep_id,int number) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		String sql="select * from easybuy_shop where eu_user_id =? and ep_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, ep_id);
			re=pstmt.executeQuery();
			if(re.next()) {
				sql="select ep_number from easybuy_shop where eu_user_id =? and ep_id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setInt(2, ep_id);
				re=pstmt.executeQuery();
				int num=0;
				while(re.next()) {
					num=re.getInt("ep_number");
				}
				if(updateNumber(userid,ep_id,num+number))
					return true;
				else
					return false;
			}else {
				sql="insert into easybuy_shop values(?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setInt(2, ep_id);
				pstmt.setInt(3, number);
				int a=pstmt.executeUpdate();
				if(a==0)
					return false;
				else
					return true;
			}
		} catch (Exception e) {
			return false;
		} finally {
			DBConn.Close(re,pstmt,con);
		}
	}
	/**
	 * 修改购物车里面的商品数量
	 * @param userid
	 * @param ep_id
	 * @param number
	 * @return
	 */
	public boolean updateNumber(String userid,int ep_id,int number) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		if(number==0) {
			delProduct(userid,ep_id);
			return true;
		}
		String sql="update easybuy_shop set ep_number=? where eu_user_id=? and ep_id=?	";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, userid);
			pstmt.setInt(3, ep_id);
			int a=pstmt.executeUpdate();
			if(a==0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		} finally {
			DBConn.Close(null,pstmt,con);
		}
	}
	
	/**
	 * 删除购物车的商品
	 * @param userid
	 * @param ep_id
	 * @return
	 */
	public boolean delProduct(String userid,int ep_id) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete from easybuy_shop where eu_user_id=? and ep_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, ep_id);
			int a=pstmt.executeUpdate();
			if(a==0)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		} finally {
			DBConn.Close(null,pstmt,con);
		}
	}
}
