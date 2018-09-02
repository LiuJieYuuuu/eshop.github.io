package com.yimai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.yimai.pojo.OrderDetail;
import com.yimai.util.DBConn;

public class OrderDetailDAO {
	/**
	 * 添加订单详情表
	 * @param list
	 * @return
	 */
	public boolean addOrderDetail(List<OrderDetail> list) {
		Connection con=DBConn.getConnection();
		PreparedStatement pstmt=null;
		String sql="insert into easybuy_order_detail values(?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				pstmt.setString(1, list.get(i).getEod_id());
				pstmt.setString(2, list.get(i).getEo_id());
				pstmt.setInt(3, list.get(i).getEp_id());
				pstmt.setInt(4, list.get(i).getEp_number());
				pstmt.setDouble(5,	list.get(i).getPrice());
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
}
