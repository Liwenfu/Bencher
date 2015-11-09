package com.example.bencher.entity;

public class testEntity2 {

	private String id;
	private String size;
	private String type;
	private String discount;
	private String originalprice;
	private String range;
	
	 public testEntity2(){
		  super();
	   }
		
	   public testEntity2(String id,String size,String type,String discount,String originalprice,String range){
		   super();
		   this.id=id;
		   this.size=size;
		   this.discount=discount;
		   this.originalprice=originalprice;
		   this.range = range;
	   }
	   @Override
	   public String toString() {
	   	// TODO Auto-generated method stub
	   	return "TestEntity [id=" + id + ",size=" + size + ",discount="+ discount +",originalprice="+originalprice+",range="+range+"]";

	   }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getOriginalprice() {
		return originalprice;
	}

	public void setOriginalprice(String originalprice) {
		this.originalprice = originalprice;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
}
