package com.oracle.shop.model.daoImpl.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.shop.model.daoImpl.CommonDaoImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracle.shop.util.JdbcTemplate;
import com.oracleoaec.exception.DataAccessException;

public class ShopUserImpl extends CommonDaoImpl<ShopUser> {

	@Override
	public ShopUser findShopUser(final String name) {
		//查询用户单条
		return JdbcTemplate.singleQuery("select username,userpassword from shop_user where username=?",
				new JdbcTemplate.PreparedStateMentSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, name);
			}
		}, createHandler());
	}
//注册用户
	@Override
	public int save(final ShopUser t) {
		return JdbcTemplate.update("insert into shop_user(userid,username,usertel,userpassword)"
				+ " values(s_shopuser.nextval,?,?,?)",new JdbcTemplate.PreparedStateMentSetter(){
					@Override
					public void setValues(PreparedStatement pstmt)
							throws SQLException {
						pstmt.setString(1, t.getUserName());
						pstmt.setString(2, t.getUserTel());
						pstmt.setString(3, t.getUserPassword());
						
					}
				});
	}
//根据电话查用户
	@Override
	public ShopUser findShopUserT(final String tel) {
		return JdbcTemplate.singleQuery("select username,userpassword from shop_user where usertel=?",
				new JdbcTemplate.PreparedStateMentSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, tel);
			}
		}, createHandler());
	}

	private JdbcTemplate.RowCallBackHandel<ShopUser> createHandler(){
		return new JdbcTemplate.RowCallBackHandel<ShopUser>() {
			@Override
			public ShopUser processRow(ResultSet re) throws SQLException {
				ShopUser user=new ShopUser();
				user.setUserName(re.getString("username"));
				user.setUserPassword(re.getString("userpassword"));
				return user;
			}
			
		};
	}
	/**
	 * 
	 */
	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserOrderlist> findOrderlist(int status,String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<GoodsType> getType() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getTotalGoods() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
