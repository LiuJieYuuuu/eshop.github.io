package com.yimai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yimai.pojo.Order;
import com.yimai.util.DBConn;

public class OrderDAO {
	/**
	 * 获取对应的状态
	 * @param status
	 * @return
	 */
	private String getStatus(int status) {
		switch(status) {
		case 1:return "审核";
		case 2:return "审核通过";
		case 3:return "配货";
		case 4:return "卖家已发货";
		case 5:return "已收货";
		default:return "";
		}
	}
	/**
	 * 获取分页查询的所有订单信息
	 * @return
	 */
	public List<Order> getOrders(int cpage,int pageSize,String eo_id,String username){
		int begin,end;
		begin =(cpage-1)*pageSize+1;
		end=cpage*pageSize;
		List<Order> list=new ArrayList<Order>();
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		Order ao=null;
		StringBuffer sql=new StringBuffer();
		sql.append("select eo_id,eo_user_name,eo_user_address,eo_status from ");
		sql.append(" (select eo.*,rownum rn from easybuy_order eo ");
		if(eo_id!=null && username!=null)
			sql.append(" where eo.eo_id='"+eo_id+"' and eo.eo_user_name='"+username+"' ");
		if(eo_id==null && username!=null)
			sql.append(" where eo.eo_user_name='"+username+"' ");
		if(eo_id!=null && username==null)
			sql.append(" where eo.eo_id='"+eo_id+"' ");
		sql.append(" order by rn) where rn between ? and ?");
		try {
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			re=pstmt.executeQuery();
			while(re.next()) {
				ao=new Order();
				ao.setEo_id(re.getString("eo_id"));
				ao.setUsername(re.getString("eo_user_name"));
				ao.setAddress(re.getString("eo_user_address"));
				ao.setStatus(re.getInt("eo_status"));
				list.add(ao);
			}
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			DBConn.Close(re, pstmt, con);
		}
	}
	
	/**
	 * 添加订单并且生成订单号
	 * @param list
	 * @return
	 */
	public boolean addOrder(List<Order> list) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into easybuy_order values(?,?,?,?,sysdate,?,1)";
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				pstmt.setString(1, list.get(i).getEo_id());
				pstmt.setString(2, list.get(i).getUserid());
				pstmt.setString(3, list.get(i).getUsername());
				pstmt.setString(4, list.get(i).getAddress());
				pstmt.setDouble(5, list.get(i).getCost());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			con.commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			DBConn.Close(null, pstmt, con);
		}
	}
	/**
	 * 获取订单表的总记录数
	 * @return
	 */
	public int getRecords() {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		ResultSet re=null;
		String sql="select count(1) from easybuy_order";
		try {
			pstmt=con.prepareStatement(sql);
			re=pstmt.executeQuery();
			int count=0;
			while(re.next()) {
				count=re.getInt(1);
			}
			return count;
		} catch (Exception e) {
			return 0;
		} finally {
			DBConn.Close(re, pstmt, con);
		}
	}
}
