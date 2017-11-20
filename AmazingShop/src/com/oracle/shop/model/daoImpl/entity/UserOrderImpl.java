package com.oracle.shop.model.daoImpl.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.midi.Sequence;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.Seqence;
import com.oracle.shop.model.entity.UserOrder;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.util.JdbcTemplate;
import com.oracle.shop.util.JdbcTemplate.PreparedStateMentSetter;
import com.oracleoaec.exception.DataAccessException;

public class UserOrderImpl extends CommonDaoImpl<UserOrder> {

	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<GoodsType> getType() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(final UserOrder t) {
		return JdbcTemplate.update("insert into user_order values(?,?,?,?,?)",
			new PreparedStateMentSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, t.getOrderId());
				pstmt.setDate(2, t.getOrderTiem());
				pstmt.setDouble(3, t.getTotal());
				pstmt.setInt(4, t.getOrderType());
				pstmt.setString(5, t.getOrderUser());
			}
		});
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
