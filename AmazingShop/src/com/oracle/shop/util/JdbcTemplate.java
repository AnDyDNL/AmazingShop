package com.oracle.shop.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
	public static interface PreparedStateMentSetter{
		void setValues(PreparedStatement pstmt)throws SQLException;

	}
	public static interface RowCallBackHandel<T>{
		T processRow(ResultSet re)throws SQLException;

	}
	//更新单条方法
	public static int update(String sql,PreparedStateMentSetter setter){
		PreparedStatement pstmt=null;
		try {
			pstmt = Factory.getConnction().prepareStatement(sql);
			if (null != setter) {
				setter.setValues(pstmt);
			}
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			//关闭资源
			//CloseConn.close(null, pstmt, null, null);;
		}
		return 0;
	}
	
	//更新多条数据
	//更新的方法
		public static int[] update(String sql,PreparedStateMentSetter ...setter){
			PreparedStatement pstmt=null;
			try {
				pstmt = Factory.getConnction().prepareStatement(sql);
				if (null != setter) {
					for (PreparedStateMentSetter setters : setter) {
						setters.setValues(pstmt);
					}
				}
				return pstmt.executeBatch();
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally{
				//关闭资源
				CloseConn.close(null, pstmt, null, null);;
			}
			return null;
		}	
		//查询集合
		public static  <T> List<T> Query(String sql,PreparedStateMentSetter setter,RowCallBackHandel<T> handel){
			ResultSet re=null;
			List<T> list=null;
			try {
				re=query(sql, setter);
				if(handel!=null){
					list=new ArrayList<T>();
					while(re.next()){
					list.add(handel.processRow(re));
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				//关闭资源
				CloseConn.close(null, null, null, re);;
			}
			return list;	
		}
		public static <T> List<T> Query(String sql,RowCallBackHandel<T> handel){
			return Query(sql,null,handel);
		}
		
		public static <T> T singleQuery(String sql,RowCallBackHandel<T> handel){
			return singleQuery(sql,null,handel);
		}
		
		//查询单条
		public static <T> T singleQuery(String sql,PreparedStateMentSetter setter,RowCallBackHandel<T> handel){
			ResultSet re=null;
			@SuppressWarnings("unused")
			List<T> list=null;
			try {
				re=query(sql, setter);
				if(handel!=null&&re.next()){
					return handel.processRow(re);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				//关闭资源
				CloseConn.close(null, null, null, re);;
			}
			return null;	
		}
	
		public static ResultSet query(String sql,PreparedStateMentSetter setter) throws SQLException{
			PreparedStatement pstmt=Factory.getConnction().prepareStatement(sql);
			if(null!=setter){
				setter.setValues(pstmt);
			}
			return pstmt.executeQuery();	
		}	
		
}
