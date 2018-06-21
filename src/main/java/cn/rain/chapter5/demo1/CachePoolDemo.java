package cn.rain.chapter5.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description: 创建一个可缓存线程池，如果线程池长度超过处理需要（即线程池中创建的线程过多，实际线程没这么多），
 *              可灵活回收空闲线程；若线程池长度不足，且无可回收的空闲线程，则新建线程。
 *              执行下面代码后我们会发现，现在需要执行100个任务，但并不是就帮我们创建100条线程，具体创建了几个线程，
 *              每次运行都不一样，这是由线程池来为我们创建的，具体数量我们不用关心，线程池会灵活的帮我们创建。
 *
 * @author 任伟
 * @date 2018/6/21 10:42
 */
@SuppressWarnings("all")
public class CachePoolDemo {
    public static void main(String[] args) {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        // 我们通过调用ExecutorService的execute(Runnable target)方法，
        // 将要执行的目标（即Runnable接口的实现类，重写了run方法）传入，之后线程池会帮我们创建线程并执行run方法。
        for (int i=0; i < 100; i++){ //这里我们循环100次，即执行100个target（任务）
            int temp = i;
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 匿名内部类想引用外部的变量，那么外部变量必须是final修饰的。
                    // 这就是为什么要用一个temp变量不直接用i
                    System.out.println("线程名: " + Thread.currentThread().getName()
                            + "在执行第" + ( temp+1 ) + "个任务");
                }
            });
        }
        /*
         * 所有线程都执行完毕后，程序不会停掉，因为线程池没有关闭，需要我们手动关闭
         * 这里我们不用担心由于CPU调度问题，而先执行到（主线程中）关闭的代码。因为
         * 线程池内部已经帮我们处理好了这个问题，当其他全部线程执行完毕后，才会向下
         * 执行关闭。
         */
        newCachedThreadPool.shutdown();

    }
}
