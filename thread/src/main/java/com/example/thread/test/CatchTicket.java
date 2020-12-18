package com.example.thread.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:jinjian.song
 * @Date:2019/6/5 10:59
 * @Description:
 */
class PersonOne implements Runnable {
    private int count = 100;

    //ReentrantLock lock= new ReentrantLock();
    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
           /* lock.lock();
            sale();
            lock.unlock();*/
        }
    }

    public synchronized void sale() {

        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }
}


public class CatchTicket {
    public static void main(String[] args) {

        PersonOne p = new PersonOne();
        new Thread(p, "线程一").start();
        new Thread(p, "线程二").start();
        new Thread(p, "线程三").start();
    }
}