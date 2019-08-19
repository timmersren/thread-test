package cn.rain.chapter2.demo4;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/20 14:39
 */
public class VerifySynchronizedMain {
    public static void main(String[] args) {
        VerifySynchronizedThread verifyThread = new VerifySynchronizedThread();

        Thread t1 = new Thread(verifyThread, "窗口1--");
        Thread t2 = new Thread(verifyThread, "窗口2--");

        t1.start();

        // 这里设置休眠是为了防止资源一直被t1占用
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // t1开启后由于flag的默认值是true，因此t1会进入【同步代码块】的while循环
        // 在这里将flag设置为false然后再开启t2，这会让t2进入【同步函数】的while循环
        verifyThread.flag = false;
        t2.start();
    }
}
