package cn.rain.chapter1.demo5;

/**
 * description: 演示join()方法的作用，join作用是让其他线程变为等待，直到该线程执行完以后，其他线程才会执行。
 *              最终的结果由于t1在t2线程启动前就使用了join()方法，因此直到t1执行完成后，t2才会开始执行，最终
 *              的结果就是t1执行完成后，t2和main线程交替执行。
 * @author 任伟
 * @date 2018/4/20 13:14
 */
@SuppressWarnings("all")
public class JoinThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; i++){
                    System.out.println("t1线程执行...【" + i + "】");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; i++){
                    System.out.println("t2线程执行...【" + i + "】");
                }
            }
        });

        t1.start();
        // t1 调用join方法，让t1线执行完成。
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        for (int i=0; i<100; i++){
            System.out.println("Main线程执行...【" + i + "】");
        }
    }

}
