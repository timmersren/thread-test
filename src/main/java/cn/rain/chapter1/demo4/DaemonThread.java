package cn.rain.chapter1.demo4;

/**
 * description: 演示守护线程。
 *  Java中有两种线程，一种是用户线程，另一种是守护线程。
 *  用户线程是指用户自定义创建的线程，主线程停止时用户线程不会停止，我们创建的线程默认都是用户线程。
 *  守护线程当进程不存在或主线程停止，守护线程也会被停止，例如gc线程。
 *  我们可以使用setDaemon(true)方法将线程设置为守护线程。
 *
 *  这里说一下输出结果中为什么已经打印了“主线程执行完毕！”守护线程依然会继续执行。首先我们要知道
 *  当执行到“主线程执行完毕！”这个输出语句的时候并不代表着主线程就彻底结束了，只能说它执行完了我们
 *  写的最后一行代码，当执行完代码后它其实还会有一些销毁工作，就像Spring容器的销毁一样。因此我们说
 *  守护线程是当主线程彻底销毁的时候才会一起销毁，因此在主线程打印完“主线程执行完毕！”和它真正销毁
 *  之间还有一段时间，故守护线程在这段时间还会继续执行（但是我们可以注意到守护线程并没有执行完for循环）。
 *
 * @author 任伟
 * @date 2018/4/20 11:11
 */
@SuppressWarnings("all")
public class DaemonThread {
    public static void main(String[] args) {
        // 1. 创建用户线程
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; i++){
                    System.out.println("守护线程运行....【" + i + "】");
                }
            }
        });
        // 2. 将用户线程设置为守护线程
        t.setDaemon(true);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread run...【" + i + "】");
        }
        System.out.println("主线程执行完毕！！！");
    }

}
