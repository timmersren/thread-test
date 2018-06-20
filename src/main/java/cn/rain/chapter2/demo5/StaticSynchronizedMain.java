package cn.rain.chapter2.demo5;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/20 14:55
 */
public class StaticSynchronizedMain {
    public static void main(String[] args) {
        StaticSynchronizedThread staticThread = new StaticSynchronizedThread();

        Thread t1 = new Thread(staticThread, "窗口1--");
        Thread t2 = new Thread(staticThread, "窗口2--");

        t1.start();

        // 这里设置休眠是为了防止资源一直被t1占用
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // t1开启后由于flag的默认值是true，因此t1会进入同步代码块的while循环
        // 在这里将flag设置为false然后再开启t2，这会让t2进入同步函数的while循环
        staticThread.flag = false;
        t2.start();
    }
}
