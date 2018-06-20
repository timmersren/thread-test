package cn.rain.chapter2.demo6;

/**
 * description: 演示死锁的Main函数
 *
 * @author 任伟
 * @date 2018/6/20 15:14
 */
public class DeadSynchronizedMain {
    public static void main(String[] args) {

        DeadSynchronizedThread deadThread = new DeadSynchronizedThread();

        Thread t1 = new Thread(deadThread, "窗口1--");
        Thread t2 = new Thread(deadThread, "窗口2--");
        t1.start();
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deadThread.flag = false;
        t2.start();
    }
}
