package com.example.adaptar.demo02;

/**
 * 德国插座
 */
public class DBSocket implements DBSocketInterface{

	@Override
	public void DBSocketInterfacecharge() {
		System.out.println("使用德国标准的充电器");
	}
}