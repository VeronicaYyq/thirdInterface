package com.example.factory.simpleFactory.produce;


import com.example.factory.simpleFactory.bean.BMW320;

public class Factory {
	public BMW320 createBMW(int type) {
		switch (type) {
		
		case 320:
			return new BMW320();
 
		default:
			break;
		}
		return null;
	}
}