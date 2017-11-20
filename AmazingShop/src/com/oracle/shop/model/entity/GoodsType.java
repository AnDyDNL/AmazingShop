package com.oracle.shop.model.entity;

import java.io.Serializable;

/**
 * 产品类型
 * 
 */
public class GoodsType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int typeId;//类型id
	private String name;
	
	public GoodsType() {
	}
	public GoodsType(int id, int typeId, String name) {
		this.id = id;
		this.typeId = typeId;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", typeId=" + typeId + ", name=" + name
				+ "]";
	}
	
}
