package cn.rain.chapter3.demo3;

import cn.rain.chapter3.entity.User3;

/**
 * description: 通过wait-notify机制，使生产者生产一个消费者就消费一个，
 *              消费完一个再生产一个新的然后再消费，如此往复。
 *
 *              这里再说一下notify和notifyAll的区别，notify是唤醒所有处于wait状态中的某一个线程，
 *              具体唤醒哪个由JVM决定，我们可以理解成随机唤醒一个，其他没有被唤醒的依然处于wait状态，
 *              不具备争抢CPU执行权的资格；而notifyAll，是唤醒所有处于wait状态的线程，让他们都具有
 *              争抢CPU执行权的资格，从而让他们接下来去争夺执行权，谁争到锁的资源谁就执行。
 *
 *              另外需要注意的是：
 *              1. wait-notify机制，必须要在同步（synchronized）中使用，不能在jdk1.5的并发包中使用。
 *              2. 如果某个对象没有被作为锁（即synchronized的锁对象），而调用该对象的wait、notify方法，
 *                 程序会报错。
 * @author 任伟
 * @date 2018/6/20 23:07
 */
public class Demo3Main {
    public static void main(String[] args) {
        User3 user3 = new User3();
        ProducerThreadDemo3 producerThreadDemo3 = new ProducerThreadDemo3(user3);
        ConsumerThreadDemo3 consumerThreadDemo3 = new ConsumerThreadDemo3(user3);

        Thread producer = new Thread(producerThreadDemo3);
        Thread consumer = new Thread(consumerThreadDemo3);
        producer.start();
        consumer.start();
    }
}
