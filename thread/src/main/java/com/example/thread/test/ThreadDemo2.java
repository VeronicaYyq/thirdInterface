package com.example.thread.test;

public class ThreadDemo2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Thread.currentThread().getName()获取当前操作该类的线程名
            System.out.println(Thread.currentThread().getName() + "拿走第" + ticket--);


        }
    }

    public static void main(String[] args) {

        ThreadDemo2 threadDemo1 = new ThreadDemo2();
        // 如果直接run就是调用一个普通类的一个方法，就体会不到多线程抢占时间片
//          threadDemo1.run();
        // 把实现Runnable接口的类当作Thread类的构造方法入参，此时，多个Thread传如同一个入参
        new Thread(threadDemo1, "线程1").start();
        new Thread(threadDemo1, "线程2").start();
        new Thread(threadDemo1, "线程3").start();
    }
}