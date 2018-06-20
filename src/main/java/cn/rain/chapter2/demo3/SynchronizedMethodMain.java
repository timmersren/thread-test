package cn.rain.chapter2.demo3;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/20 14:14
 */
public class SynchronizedMethodMain {
    public static void main(String[] args) {
        SynchronizedMethodThread methodThread = new SynchronizedMethodThread();
        Thread t1 = new Thread(methodThread, "窗口1");
        Thread t2 = new Thread(methodThread, "窗口2");

        t1.start();
        t2.start();
    }
}
