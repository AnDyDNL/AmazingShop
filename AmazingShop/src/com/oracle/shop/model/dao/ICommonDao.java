package com.oracle.shop.model.dao;
import java.util.ArrayList;
import java.util.List;
import com.oracle.shop.model.entity.Comments;
import com.oracle.shop.model.entity.Goods;
import com.oracle.shop.model.entity.GoodsType;
import com.oracle.shop.model.entity.Seqence;
import com.oracle.shop.model.entity.ShopUser;
import com.oracle.shop.model.entity.UserOrderlist;
import com.oracleoaec.exception.DataAccessException;
public interface ICommonDao<T> extends java.io.Serializable{
	/**
	 * 谌敦伟写的方法
	 * */
	ShopUser findShopUser(String name);
	/**
	 * @author 朱彬
	 * 根据ID查找商品详情页的信息
	 * */
	T findByID(int id);

	int save(T t);//谌敦伟插入数据
	ShopUser findShopUserT(String tel);                    //谌敦伟根据手机号查找数据
	//根据类查找商品
	List<Goods> findByType(int id) throws DataAccessException;
	
	
	/**
	 * 朱彬查询订单明细
	 * */
	List<UserOrderlist> findOrderlist(int status,String name);
	
	//根据商品id查找评论
	List<Comments> findcomm(int id);

	
	/**
	 * @author 丁宁乐
	 * 查询商品类别和类别ID
	 * @return
	 * @throws DataAccessException 
	 */
	 ArrayList<GoodsType> getType() throws DataAccessException;
	
	
	
	
	
	
	//查找序列
	Seqence selectSeq();
	
	

	
	/**
	 * 朱彬根据id删除订单明细表的方法
	 * */
	int delete(int id);
	
	/**
	 * zhubin更新orderlist表
	 * */
	int updateOrderList(UserOrderlist u);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//根据用户名更改
	int uppass(T t);

	//模糊查询1
	GoodsType findname(String s);
	//模糊查询2
	Goods findtyid(String s);
	//查看订单状态
	UserOrderlist findordertype(int t);


	 /**
		 * @author 丁宁乐
		 * 查找到商品类别的总数
		 * @return
		 * @throws DataAccessException 
		 */

	int getTotalGoods() throws DataAccessException;

	List<Goods> findgoods(String name);
}
