package cn.rain.chapter2.demo1;

/**
 * description: 出售100张票的Thread类，同时开启多个线程会产生线程安全问题
 * @author 任伟
 * @date 2018/6/20 13:32
 */
public class SellTicketThread implements Runnable{

    private int ticketCount = 100;

    @Override
    public void run() {
        while (ticketCount > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    private void sale() {
        if (ticketCount > 0) {
            System.out.println(Thread.currentThread().getName()
                    + "正在出售第" + (100 - ticketCount + 1) + "张票");
            ticketCount --;
        }
    }
}
