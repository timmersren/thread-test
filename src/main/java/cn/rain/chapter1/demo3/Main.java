package cn.rain.chapter1.demo3;

import java.util.concurrent.FutureTask;

/**
 * description: 通过demo2中实现Runnable接口的匿名内部类方式创建线程。
 * @author 任伟
 * @date 2018/4/20 10:59
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) throws Exception {

        Mythread3 mythread3 = new Mythread3();
        FutureTask<Integer> ft = new FutureTask<>(mythread3);
        Thread t3 = new Thread(ft);
        t3.start();

        Integer result = ft.get();

        System.out.println("task result is : " + result);
        System.out.println("main is end...");
    }
}
