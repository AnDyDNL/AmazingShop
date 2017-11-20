package com.oracle.shop.model.daoImpl;
import java.util.List;

import com.oracle.shop.model.dao.ICommonDao;
import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.Seqence;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracleoaec.exception.DataAccessException;


public abstract class CommonDaoImpl<T> implements ICommonDao<T> {

	@Override
	public ShopUser findShopUser(String name) {
		return null;
	}
	//谌敦伟插入数据
	@Override
	public int save(T t) {
		return 0;
	}
	//谌敦伟查询数据
	@Override
	public ShopUser findShopUserT(String tel) {
		return null;
	}
	
	/**
	 * @author 朱彬
	 * 根据ID查找商品详情页的信息
	 * */
	@Override
	public T findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	//根据商品id查找评论
	@Override
	public List<Comments> findcomm(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<UserOrderlist> findOrderlist(int status,String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//带头大哥重写的方法
	@Override
	public int updateOrderList(UserOrderlist u) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Seqence selectSeq() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Goods> findByType(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//查找订单状态
	@Override
	public UserOrderlist findordertype(int t) {
		// TODO Auto-generated method stub
		return null;
	}
	//大爷重写改密码
	@Override
	public int uppass(T t) {
		// TODO Auto-generated method stub
		return 0;
	}
	//模糊查询1
	@Override
	public GoodsType findname(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Goods findtyid(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Goods> findgoods(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
