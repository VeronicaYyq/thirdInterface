package com.example.thread.test;
/**
 *   我的java每天100行代码008
 *  利用多线程实现抢票（线程不安全）
 * @author Administrator
 *
 */
public class java0081 {
	public static void main(String[] args) {
		
		Web12306 w = new Web12306();
		
		Thread t = new Thread(w,"小狗");
		t.start();
		
		Thread t1 = new Thread(w,"小猫");
		t1.start();
		
		Thread t2 = new Thread(w,"小猪");
		t2.start();
	}

}

class Web12306 implements Runnable{
	private int ticketNums = 99;
	
	public void run(){
		while(true) {
			if(ticketNums<0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
		}
	}
}
