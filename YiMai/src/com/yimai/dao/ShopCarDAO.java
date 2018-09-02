package com.yimai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yimai.ov.ShopCar;
import com.yimai.util.DBConn;

public class ShopCarDAO {
	/**
	 * 查询用户和商品固定的购物信息
	 * @param userid
	 * @param ep_id
	 * @return
	 */
	public ShopCar getShops(String userid,int ep_id) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		ShopCar sc=null;
		String sql="select s.ep_id,s.ep_number,p.ep_file_name,p.ep_price,p.ep_name "
				+ "from (select * from easybuy_shop) s,easybuy_product p "
				+ "where s.ep_id=p.ep_id and s.eu_user_id=? and s.ep_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, ep_id);
			re=pstmt.executeQuery();
			while(re.next()) {
				sc=new ShopCar();
				sc.setEp_id(re.getInt("ep_id"));
				sc.setNumber(re.getInt("ep_number"));
				sc.setEp_name(re.getString("ep_name"));
				sc.setPrice(Double.parseDouble(String.format("%.2f", re.getDouble("ep_price")*re.getInt("ep_number"))));
				sc.setFilename(re.getString("ep_file_name"));
			}
			return sc;
		} catch (Exception e) {
			return null;
		}finally {
			DBConn.Close(re, pstmt, con);
		}
	}
	
	/**
	 * 查询所有购物车的商品
	 * @param userid
	 * @return
	 */
	public List<ShopCar> getShopCar(String userid){
		List<ShopCar> list=new ArrayList<ShopCar>();
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		ShopCar sc=null;
		String sql="select s.ep_id,s.ep_number,p.ep_file_name,p.ep_price,p.ep_name "
				+ "from (select * from easybuy_shop) s,easybuy_product p "
				+ "where s.ep_id=p.ep_id and s.eu_user_id=? ";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			re=pstmt.executeQuery();
			while(re.next()) {
				sc=new ShopCar();
				sc.setEp_id(re.getInt("ep_id"));
				sc.setNumber(re.getInt("ep_number"));
				sc.setEp_name(re.getString("ep_name"));
				sc.setPrice(Double.parseDouble(String.format("%.2f", re.getDouble("ep_price")*re.getInt("ep_number"))));
				sc.setFilename(re.getString("ep_file_name"));
				list.add(sc);
			}
			return list;
		} catch (Exception e) {
			return null;
		}finally {
			DBConn.Close(re, pstmt, con);
		}
	}
	/**
	 * 删除购物车里面的商品
	 * @param userid
	 * @param ep_id
	 * @return
	 */
	public boolean delShopCar(String userid,int ep_id) {
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
		}finally {
			DBConn.Close(null, pstmt, con);
		}
	}
}
