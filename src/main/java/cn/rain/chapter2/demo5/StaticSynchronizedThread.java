package cn.rain.chapter2.demo5;

/**
 * description: 演示静态同步函数。
 *              静态的同步函数使用的锁是该函数所属字节码文件对象。
 *              可以用getClass()方法获取锁，也可以用当前类名.class 表示。
 *
 * @author 任伟
 * @date 2018/6/20 14:51
 */
@SuppressWarnings("all")
public class StaticSynchronizedThread implements Runnable {
    private static int train1Count = 100;
    public boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (train1Count > 0) {
                // 静态同步函数使用的锁是该函数所在类的.class 对象
                // 可以使用类名.class获取该锁（如下），亦可使用getClass()方法获取。
                synchronized (StaticSynchronizedThread.class) {
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

    public static synchronized void sale() {
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
