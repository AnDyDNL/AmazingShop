package com.oracle.shop.model.entity;
/**
 * 品牌表
 */
public class BrandTable {
	private int brandId;//品牌id
	private int typeId;//类型id
	private String brandName;//品牌名
	private String brandDiscribe;//品牌描述
	
	public BrandTable() {
	}
	public BrandTable(int brandId, int typeId, String brandName,
			String brandDiscribe) {
		this.brandId = brandId;
		this.typeId = typeId;
		this.brandName = brandName;
		this.brandDiscribe = brandDiscribe;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
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
	public String getBrandDiscribe() {
		return brandDiscribe;
	}
	public void setBrandDiscribe(String brandDiscribe) {
		this.brandDiscribe = brandDiscribe;
	}
	
}
