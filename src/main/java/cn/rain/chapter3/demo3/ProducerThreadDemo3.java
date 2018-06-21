package cn.rain.chapter3.demo3;

import cn.rain.chapter3.entity.User3;

/**
 * description: 生产者线程，使用wait-notify机制。
 *
 * @author 任伟
 * @date 2018/6/20 23:05
 */
@SuppressWarnings("all")
public class ProducerThreadDemo3 implements Runnable {

    private User3 user;

    ProducerThreadDemo3(User3 user) {
        this.user = user;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (user) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果flag为true，那么生产者调用锁的wait方法将锁的控制权交出去，
                //此时消费者就能拿到锁的控制器，那么消费者就能执行，直至执行完成后更改flag状态。
                if (user.isFlag()) {
                    try {
                        //此线程调用wait后，那么它会一直等待，直到持有该锁的其他线程使用notify将其唤醒。
                        user.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 0) {
                    System.out.println("生产者将user设置成了 大力-男");
                    user.setUsername("大力");
                    user.setGender("男");
                } else {
                    System.out.println("生产者将user设置成了 小兰-女");
                    user.setUsername("小兰");
                    user.setGender("女");
                }
                count = (count + 1) % 2;
                user.setFlag(true);
                user.notify();
            }
        }
    }
}
