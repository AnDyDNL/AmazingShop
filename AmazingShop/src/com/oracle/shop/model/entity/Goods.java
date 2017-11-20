package com.oracle.shop.model.entity;
/** 
 * 产品
 */
public class Goods {
	private double price;
	private int id;
	private int typeId;//类型id
	private String brandName;//品牌名
	private int brandId;//品牌id
	private String goodsName;//产品名
	private String goodsDiscribe;//商品描述
	private String imgpath;
	
	public Goods() {
	}
	public Goods(int id, int typeId, String brandName, int brandId,
			String goodsName, String goodsDiscribe,double price,String imgpath) {
		this.id = id;
		this.typeId = typeId;
		this.brandName = brandName;
		this.brandId = brandId;
		this.goodsName = goodsName;
		this.goodsDiscribe = goodsDiscribe;
		this.price=price;
		this.imgpath=imgpath;
	}
	
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsDiscribe() {
		return goodsDiscribe;
	}
	public void setGoodsDiscribe(String goodsDiscribe) {
		this.goodsDiscribe = goodsDiscribe;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", typeId=" + typeId + ", brandName="
				+ brandName + ", brandId=" + brandId + ", goodsName="
				+ goodsName + ", goodsDiscribe=" + goodsDiscribe + ", price="
				+ price + ", imgpath=" + imgpath + "]";
	}
	
	
}
