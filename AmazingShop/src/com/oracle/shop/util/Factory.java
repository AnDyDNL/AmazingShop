package com.oracle.shop.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Factory {
	private static String URL;
	private static String DRIVER;
	private static String USER;
	private static String PASSWORD;
	//静态代码块
	static{
		Properties pro=new Properties();
		//获取流
		InputStream in=Factory.class.getResourceAsStream("./jdbc.properties");
		//加载配置文件
		try {
			pro.load(in);
			//ֵ
			DRIVER = pro.getProperty("driver");
			URL=pro.getProperty("url");
			USER=pro.getProperty("user");
			PASSWORD=pro.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 获取连接对象
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnction() throws SQLException{
		Connection conn=null;
		try {
			//加载驱动
			Class.forName(DRIVER);
			//配置参数获取连接对象
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		
	}
	
	//测试成功
	public static void main(String[] args) throws SQLException {
		Connection connction = Factory.getConnction();
		//System.out.println(connction);
	}
}
