package cn.rain.chapter3.demo1;

import cn.rain.chapter3.entity.User;

/**
 * description: 演示线程间通信出现的线程安全问题。
 *              运行后会发现，小兰会出现男，大力会出现女。这是由于生产者线程生产 大力-男之后，
 *              消费者线程读取username为大力，然后此时消费者线程停止，接着再调用生产者线程生产 小兰-女 ，
 *              此时消费者线程继续被调用，读取之前没读取完的gender为女，便产生了 大力-女 这种情形。
 *              并且此种情形是由于线程调度层面产生的线程安全问题，即使使用volatile关键字也无法解决。
 *              解决方法只能将生产过程和消费过程进行同步，即生产过程时无法消费，消费过程中也无法生产，具体看demo2中的演示。
 *
 * @author 任伟
 * @date 2018/6/20 22:30
 */
@SuppressWarnings("all")
public class Demo1Main {
    public static void main(String[] args) {
        User user = new User();
        ProducerThreadDemo1 producer = new ProducerThreadDemo1(user);
        ConsumerThreadDemo1 consumer = new ConsumerThreadDemo1(user);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
