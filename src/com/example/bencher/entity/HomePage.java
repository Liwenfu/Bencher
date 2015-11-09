package com.example.bencher.entity;

public class HomePage {

	private String bus_name;
	private String bus_introdiction;
	private String bus_image;
	
	public HomePage(){
		super();
	}
	
	public HomePage(String bus_name,String bus_introdiction,String bus_image){
		this.bus_name = bus_name;
		this.bus_introdiction = bus_introdiction;
		this.bus_image = bus_image;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub´ýÍêÉÆ
		return super.toString();
	}

	public String getBus_name() {
		return bus_name;
	}

	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}

	public String getBus_introdiction() {
		return bus_introdiction;
	}

	public void setBus_introdiction(String bus_introdiction) {
		this.bus_introdiction = bus_introdiction;
	}

	public String getBus_image() {
		return bus_image;
	}

	public void setBus_image(String bus_image) {
		this.bus_image = bus_image;
	}
	
	
}
