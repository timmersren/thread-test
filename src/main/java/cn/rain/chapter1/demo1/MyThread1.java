package cn.rain.chapter1.demo1;

/**
 * description: 演示创建线程的第一种方式，继承Thread类并重写run()方法。
 * @author 任伟
 * @date 2018/4/20 10:21
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i=0; i < 10; i++){
            System.out.println("t1 run....【" + i + "】");
        }
    }
}
