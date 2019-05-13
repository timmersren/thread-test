package cn.rain.chapter1.exercise.exe2;

/**
 * description:有t1,t2,t3三条线程，要求t1执行完之后t2再执行，t2执行完成后t3再执行。
 * 要点：线程A让线程B先执行，要在线程A内部调用threadB.join()。切记注意不要错在主线程中调用，
 * 那样只是主线程等待其他线程。
 *
 * @author 任伟
 * @date 2018/4/20 13:54
 */

@SuppressWarnings("all")
public class ThreeThread {
    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("t1...." + i);
                }
            }
        });
        t1.start();

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 在t2的业务逻辑执行前，调用t1.join。
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 100; i++) {
                    System.out.println("t2...." + i);
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 在t3的业务逻辑执行前，调用t2.join。
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 100; i++) {
                    System.out.println("t3...." + i);
                }
            }
        });
        t3.start();

    }
}
