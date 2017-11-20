package com.oracle.shop.util;
import java.util.ArrayList;

import com.oracle.shop.model.daoImpl.entity.TypeImpl;
import com.oracle.shop.model.entity.Goods;
import com.oracleoaec.exception.DataAccessException;

public class Test {

	
	public static void main(String[] args) throws DataAccessException {
		//test findByType
		
//		ArrayList<Goods> goods =(ArrayList<Goods>)findGoods.findByType(3);	
//		for (Goods good : goods) {
//			System.out.println(good.getGoodsName());
//		}
		//GoodsImpl findGoods=new GoodsImpl();
//		ArrayList<GoodsType> type = findGoods.getType();
//		for (GoodsType goodsType : type) {
//			System.out.println(goodsType);
//		}
		/*TypeImpl t=new TypeImpl();
		ArrayList<Goods> list = t.getGoodsByBrand(3);
		for (Goods goods : list) {
			System.out.println(goods.toString());
		}*/
		TypeImpl goodsTotal=new TypeImpl();
		int totalGoods=goodsTotal.getTotalGoods(2,1);
		System.out.println(totalGoods);
	}
}
