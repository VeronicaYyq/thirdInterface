package com.example.proxy.bean;

import com.example.proxy.annoation.MyField;

/**
 * 
 * @author T_Antry
 * @describe 学生模板类
 * T_Antry-Test
 * 2020年9月7日
 */
public class Student {

	@MyField("11111")
	private int id;

	@MyField("YYYYYYYYYY")
	private String name;
	public void doSome() {
		
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
