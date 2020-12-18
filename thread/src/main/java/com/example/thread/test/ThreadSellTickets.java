package com.example.thread.test;

/**
 * 经典案例，多个线程卖票：用来展示多线程不安全问题
 */
public class ThreadSellTickets implements Runnable {
    //定义初始票数
    private int ticket = 100;

    Boolean flag = true;


    @Override
    public void run() {
        //循环卖票
        while (ticket >= 0) {
            buyTicket();
            /*System.out.println(Thread.currentThread().getName() + "买到了第" + ticket + "张票");
            //每次循环票数减一
            ticket--;*/
        }
    }

    private synchronized void buyTicket() {
        //判断票数是否小于等于零，如果是，将flag的值改为false，跳出循环，说明没票了
        if (ticket <= 0) {
            flag = false;
            //没票了就跳出方法
            return;
        }

        //模拟网络延时，让线程睡100ms。扩大出现错误的可能性。这里出现异常，捕获处理
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("run方法里出现了异常");
        }

        System.out.println(Thread.currentThread().getName() + "买到了第" + ticket + "张票");
        //每次循环票数减一
        ticket--;
    }

    //主线程
    public static void main(String[] args) {
        //获取ThreadSellTickets对象
        ThreadSellTickets sellTickets = new ThreadSellTickets();
        //创建多个线程，去抢票（多个线程处理同一资源）；并给线程起名字
        new Thread(sellTickets, "张三黄牛").start();
        new Thread(sellTickets, "李四黄牛").start();
        new Thread(sellTickets, "王五黄牛").start();
    }
}

