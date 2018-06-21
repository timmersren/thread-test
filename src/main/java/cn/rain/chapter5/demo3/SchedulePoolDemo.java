package cn.rain.chapter5.demo3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/21 11:32
 */
public class SchedulePoolDemo {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("系统可用的线程数为：" + availableProcessors);
        // 定时线程池首先它是定长的，这里我们用系统可用线程数量来指定
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(availableProcessors);
        for (int i = 0; i < 10; i++) {
            int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名: " + Thread.currentThread().getName()
                            + "在执行第" + ( temp+1 ) + "个任务");
                }
            /**
             * 这里要着重说明这个定时，这里设置的时间不是说线程被创建后延迟几秒再执行任务，
             * 因为线程池中的线程是在线程池一创建的时候就被创建好了，试想如果之间隔了好久都没有任务要执行，
             * 那么要怎么算这个时间，再者说，我们这10个任务，每个任务被哪条线程执行也是不确定的，
             * 因此这个定时和线程的创建时间毫无关系，其实这个定时是调用这个schedule（Runnable target）方法后，
             * 这个传入的target在调用这个方法的多长时间后，去执行这个target。
             *
             * 我们这里传入temp（temp的值就是i）的意思就是第1个任务执行的话，会在调用schedule()方法的1s后执行，
             * 第2个任务会在调用schedule()的2s后执行，以此类推，我们看到的效果就是每秒都会执行一个任务。
             * 如果我们将这个值设置成固定值，例如3。那意思就是说第1个任务在调用schedule的3秒后会执行，注意！接下来
             * 可不会阻塞，第1个任务只是在等待那3s（类似于sleep），此时立即跳入到下次循环执行第2个任务，同样第2个任务
             * 也会在3s后执行，以此类推。由于循环的速度是极快的，因此我们看到大概3s后，所有任务几乎同时做完。
             */
            }, temp, TimeUnit.SECONDS);
        }
        newScheduledThreadPool.shutdown();
    }
}
