package cn.rain.chapter2.demo4;

/**
 * description: 证明同步函数使用的是this锁
 *
 * @author 任伟
 * @date 2018/6/20 14:21
 */
@SuppressWarnings("all")
public class VerifySynchronizedThread implements Runnable {

    private static int train1Count = 100;
    private Object obj = new Object();
    public boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            // 若执行下面同步代码块的obj锁，仍然出现线程安全问题
            // 执行同步代码块this锁，不会出现安全问题，从而证实同步函数使用的是this锁
            while (train1Count > 0) {
//                synchronized (obj) {
                synchronized (this) {
                    if (train1Count > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - train1Count + 1) + "票");
                        train1Count--;
                    }
                }

            }
        } else {
            // 执行同步函数
            while (train1Count > 0) {
                sale();
            }
        }
    }

    public synchronized void sale() {
        if (train1Count > 0) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - train1Count + 1) + "票");
            train1Count--;
        }
    }
}
