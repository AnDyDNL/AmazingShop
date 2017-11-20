package com.oracle.shop.model.daoImpl.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.util.JdbcTemplate;
import com.oracle.shop.util.JdbcTemplate.PreparedStateMentSetter;
import com.oracle.shop.util.JdbcTemplate.RowCallBackHandel;
import com.oracleoaec.exception.DataAccessException;

public class FOrderTypeImpl extends CommonDaoImpl<UserOrderlist>{
	@Override
	public UserOrderlist findordertype(final int t) {
		// TODO Auto-generated method stub
		//c查看订单状态单条
		return JdbcTemplate.singleQuery("select username,ordertype from user_orderlist where ordertype>0 and goods_id=?", 
				new JdbcTemplate.PreparedStateMentSetter() {
					
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, t);
						
					}
				}, createHandler());
				
	}



	private RowCallBackHandel<UserOrderlist> createHandler() {
		// TODO Auto-generated method stub
		return new JdbcTemplate.RowCallBackHandel<UserOrderlist>() {	
			@Override
			public UserOrderlist processRow(ResultSet re) throws SQLException {
				UserOrderlist d=new UserOrderlist();
				d.setOrderType(re.getInt("ordertype"));
				d.setUserName(re.getString("username"));
				return d;
			}
		};
	}



	@Override
	public ArrayList<GoodsType> getType() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}

