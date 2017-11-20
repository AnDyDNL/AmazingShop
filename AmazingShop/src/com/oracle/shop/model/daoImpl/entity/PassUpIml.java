package com.oracle.shop.model.daoImpl.entity;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.util.JdbcTemplate;
import com.oracleoaec.exception.DataAccessException;

public class PassUpIml extends CommonDaoImpl<ShopUser>{

	@Override
	public int uppass(final ShopUser t) {
		return JdbcTemplate.update("update shop_user set userpassword=?"
				+ " where username=?", 
				new JdbcTemplate.PreparedStateMentSetter(){
					@Override
					public void setValues(PreparedStatement pstmt)
							throws SQLException {
						pstmt.setString(1,t.getUserPassword() );
						pstmt.setString(2, t.getUserName());
					}
				});
	}


	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
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
