package com.yimai.util;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.alibaba.druid.pool.DruidDataSource;

public class DBConn {
	// Oracle数据库配置的JNDI数据源连接名,后面跟的是DataSource名，DataSource名在web.xml文件中的<res-ref-name></res-ref-name>进行了配置
		private static final String ORACLE_DB_JNDINAME = "java:comp/env/jdbc/OracleDataSource";

		private static DruidDataSource dsOracle = null;
		
		
		static{
	        try {
	            //1、初始化名称查找上下文
	            Context ctx = new InitialContext();
	            //2、通过JNDI名称找到DataSource
	            dsOracle = (DruidDataSource) ctx.lookup(ORACLE_DB_JNDINAME);
	           
	        } catch (NamingException e) {
	            e.printStackTrace();
	        }
	    }

		public static Connection getConnection() {
			try {
				return dsOracle.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public static void Close(ResultSet re,PreparedStatement pstmt,Connection con) {
			try {
				if(re!=null)
					re.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (Exception e) {
				System.out.println("关闭失败");
			}
		}
}
