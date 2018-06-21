package cn.rain.chapter3.demo2;

import cn.rain.chapter3.entity.User;

/**
 * description: 生产者线程，将生产过程同步。
 *              注意这里的同步代码块不能使用this锁，因为this是本类实例对象；而消费者的this锁是消费者的实例对象
 *              这两个this不是同一个对象也即不是同一把锁，这样加锁并不能使生产和消费过程同步，因此要使用同一个对象，
 *              这里既然操作的ShareUser是生产和消费者的共享数据，那我们何不使用它来作为锁。
 *
 * @author 任伟
 * @date 2018/6/20 22:40
 */
public class ProducerThreadDemo2 implements Runnable {

    private final User user;

    ProducerThreadDemo2(User user) {
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
            }
        }
    }
}
