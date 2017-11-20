package com.oracle.shop.model.daoImpl.entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.shop.model.entity.Address;
import com.oracle.shop.util.CloseConn;
import com.oracle.shop.util.Factory;
import com.oracleoaec.common.MyTemplate;
import com.oracleoaec.common.PreparedStatementSetter;
import com.oracleoaec.common.RowCallBackHandler;
import com.oracleoaec.exception.DataAccessException;

public class AddressImpl {
	ArrayList <Address> address_List=new ArrayList<>();
	public void add_Address(final Address address) throws DataAccessException{
		//获取连接
				
				Connection conn = null;
				try {
					conn = Factory.getConnction();
					MyTemplate template=new MyTemplate(conn);
					template.query("select s_Address.nextval from dual", new RowCallBackHandler() {
						
						@Override
						public void processRow(ResultSet rs) throws SQLException {
							while(rs.next()){
								address.setId(rs.getInt(1));
							}
							
						}
					});
					template.update("insert into user_Address values(?,?,?,?,?,?)",new PreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement pstmt) throws SQLException {
							pstmt.setString(1, address.getUser_Name());
							pstmt.setString(2, address.getConsignee_Name());
							pstmt.setString(3,  address.getDetail_Address());
							pstmt.setString(4,address.getlocation());
							pstmt.setString(5, address.getConsignee_Tel());
							pstmt.setInt(6,address.getId());
						}
					});

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					CloseConn.close(conn, null, null, null);
				}

	}
	/**
	 * @author Administrator丁
	 * @return 地址的集合
	 * @param user_Name
	 */
	public ArrayList <Address> query_Address(final String user_Name) throws DataAccessException{
		//获取连接
				
				Connection conn = null;
				try {
					conn = Factory.getConnction();
					MyTemplate template=new MyTemplate(conn);
					template.query("select CONSIGNEE_NAME,CONSIGNEE_tel,detail_Address,location from user_Address where user_Name=? ", new PreparedStatementSetter() {
						
						@Override
						public void setValues(PreparedStatement pstmt) throws SQLException {
							pstmt.setString(1, user_Name);
						}
					},new RowCallBackHandler() {
						@Override
						public void processRow(ResultSet rs) throws SQLException {
							while(rs.next()){
								Address address=new Address();
								address.setConsignee_Name(rs.getString("CONSIGNEE_NAME"));
								address.setConsignee_Tel(rs.getString("CONSIGNEE_tel"));	
								address.setDetail_Address(rs.getString("detail_Address"));	
								address.setLocation(rs.getString("location"));
								address_List.add(address);
							}
							
						}
					});

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					CloseConn.close(conn, null, null, null);
				}
				return address_List;
	}
	
}
