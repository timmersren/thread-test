package cn.rain.chapter1.demo2;

/**
 * description:演示第二种方式创建的线程的开启方式，实现Runnable接口。
 * 由于Java中不存在多继承，因此使用第一种方式有局限性，如果继承了别的类则不能再继承Thread。
 * 故如果继承了其他的类可以通过实现Runnable接口的方式创建线程。
 * @author 任伟
 * @date 2018/4/20 10:53
 */
public class Main {
    public static void main(String[] args) {
        Mythread2 mythread2 = new Mythread2();
        Thread t2 = new Thread(mythread2);
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread run...【" + i + "】");
        }
    }
}
