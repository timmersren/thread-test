package cn.rain.chapter2.demo2;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/20 14:10
 */
public class SynchronizedBlockMain {
    public static void main(String[] args) {
        SynchronizedBlockThread blockThread = new SynchronizedBlockThread();
        Thread t1 = new Thread(blockThread, "窗口1");
        Thread t2 = new Thread(blockThread, "窗口2");

        t1.start();
        t2.start();
    }
}
