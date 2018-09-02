package com.yimai.dao;

import com.yimai.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.yimai.pojo.*;

public class ProductDAO {
	/**
	 * 获取相对应ep_id的产品信息
	 * @param ep_id
	 * @return
	 */
	public Product getEpIdProduct(int ep_id) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		Product product=null;
		String sql="select * from easybuy_product where ep_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, ep_id);
			re=pstmt.executeQuery();
			while(re.next()) {
				product=new Product(re.getInt("ep_id"),re.getString("ep_name"),re.getString("ep_description"),
						re.getDouble("ep_price"),re.getInt("ep_stock"),re.getString("ep_file_name"));
			}
			return product;
		} catch (Exception e) {
			return null;
		} finally {
			DBConn.Close(re, pstmt, con);
		}
	}
	
	/**
	 * 查询热卖产品
	 * @return
	 */
	public List<Product> getSpecialProducts(){
		Connection con=DBConn.getConnection();
		List<Product> list=new ArrayList<Product>();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		Product product=null;
		String sql="select * from (select e.*,rownum rn from easybuy_product e) where rn<=8";
		try {
			pstmt=con.prepareStatement(sql);
			re=pstmt.executeQuery();
			while(re.next()) {
				product=new Product(re.getInt("ep_id"),re.getString("ep_name"),re.getString("ep_description"),
						re.getDouble("ep_price"),re.getInt("ep_stock"),re.getString("ep_file_name"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			DBConn.Close(re, pstmt, con);
		}
	}
	
	/**
	 * 获取所有商品
	 * @return
	 */
	public List<Product> getProducts(){
		Connection con=DBConn.getConnection();
		List<Product> list=new ArrayList<Product>();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		Product product=null;
		String sql="select * from easybuy_product";
		try {
			pstmt=con.prepareStatement(sql);
			re=pstmt.executeQuery();
			while(re.next()) {
				product=new Product(re.getInt("ep_id"),re.getString("ep_name"),re.getString("ep_description"),
						re.getInt("ep_price"),re.getInt("ep_stock"),re.getString("ep_file_name"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			DBConn.Close(re, pstmt, con);
		}
	}
}
