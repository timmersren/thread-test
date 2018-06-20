package cn.rain.chapter2.demo1;

/**
 * description: 演示开启两个线程售票
 *
 * @author 任伟
 * @date 2018/6/20 13:38
 */
public class SellTicketMain {
    public static void main(String[] args) {

        SellTicketThread thread = new SellTicketThread();
        Thread t1 = new Thread(thread, "窗口1");
        Thread t2 = new Thread(thread, "窗口2");

        t1.start();
        t2.start();
    }
}
