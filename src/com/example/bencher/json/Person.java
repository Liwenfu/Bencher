package com.example.bencher.json;


public class Person {

	private String name;
	private Birthday birthday ;
	private int age;
	
	public Person() {
		super();
	}

	public Person(String name, int age, Birthday birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", birthday="
				+ birthday + "]";
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Birthday getBrithday() {
		return birthday;
	}

	public void setBrithday(Birthday brithday) {
		this.birthday = brithday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
