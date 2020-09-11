package com.example.factory.simpleFactory.consume;



import com.example.factory.simpleFactory.bean.BMW;
import com.example.factory.simpleFactory.produce.Factory;

public class Customer {
	public static void main(String[] args) {
		Factory factory = new Factory();
		BMW bmw320 = factory.createBMW(320);
		BMW bmw523 = factory.createBMW(523);
	}
}