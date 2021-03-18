package com.example.adaptar.demo3;

/**
 *类的适配器，直接将适配器实现目标接口，继承需要实现功能的类，只能单继承（）
 */
class Adaptee {
	public void specificRequest() {
		System.out.println("被适配类具有特殊功能...");
	}
}

// 目标接口，或称为标准接口
interface Target {
	public void request();
}

// 适配器类，继承了被适配类，同时实现标准接口
class Adapter extends Adaptee implements Target {
	public void request() {
		super.specificRequest();//特殊调用
	}
}
// 测试类
class Client {
	public static void main(String[] args) {
		// 使用特殊功能类，即适配类
		Target adapter = new Adapter();
		adapter.request();
	}
}