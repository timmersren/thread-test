package cn.rain.chapter2.demo2;

/**
 * description: 使用synchronized同步代码块解决线程安全问题
 *
 * @author 任伟
 * @date 2018/6/20 14:05
 */
@SuppressWarnings("all")
public class SynchronizedBlockThread implements Runnable{

    private int ticketCount = 100;
    /** 定义Object实例作为同步代码块中的锁 */
    private final Object object = new Object();

    @Override
    public void run() {
        while (ticketCount > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    private void sale() {
        synchronized (object){
            if (ticketCount > 0) {
                System.out.println(Thread.currentThread().getName()
                        + "正在出售第" + (100 - ticketCount + 1) + "张票");
                ticketCount --;
            }
        }
    }
}
