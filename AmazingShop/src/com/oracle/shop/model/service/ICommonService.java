package com.oracle.shop.model.service;

import java.io.Serializable;
import java.util.List;

import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.Seqence;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.entity.UserOrder;
import com.oracle.shop.model.entity.UserOrderlist;

public interface ICommonService<T> extends Serializable {
	ShopUser findShopUser(String name);                    //谌敦伟根据用户名查找数据
	int save(T t);//谌敦伟插入数据
	ShopUser findShopUserT(String tel);                    //谌敦伟根据手机号查找数据
	
	/**
	 * @author 朱彬
	 * 根据ID查找商品详情页的信息
	 * */
	Goods findGoods(int id);
	
	List<UserOrderlist> findOrderlist(int status,String name);
	
	
	
	//zhubin  cunshuju
	int save(UserOrder o);
	Seqence selectSeq();
	int update(UserOrderlist u);
	int delete(int id);
	
	
	
	//根据商品id查找评论
	List<Comments> findcomm(int id);
	
	//查看订单状态
	UserOrderlist findordertype(int t);
	
	//根据用户名更改
	int uppass(T t);
	
	//模糊查询
	GoodsType findname(String s);
	
	Goods findtyid(String s);
	
	List<Goods> findgoods(String name);
}
