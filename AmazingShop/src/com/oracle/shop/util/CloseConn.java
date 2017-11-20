package com.oracle.shop.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseConn {
	//关闭资源
		public static void close(Connection conn,PreparedStatement pstmt,Statement stmt,ResultSet rs) {

			try {
				if(conn!=null){
						conn.close();
				}
				if(null!=pstmt){
					pstmt.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(rs!=null){
					rs.close();
				}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
			
		}
}
