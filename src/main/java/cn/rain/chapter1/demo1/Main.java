package cn.rain.chapter1.demo1;

/**
 * description: 演示第一种方式创建的线程的开启方式。
 * @author 任伟
 * @date 2018/4/20 10:27
 */
public class Main {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();

        // 主线程的for循环
        for (int i=0; i < 10; i++){
            System.out.println("Main thread run...【" + i + "】");
        }
    }
}
