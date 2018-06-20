package cn.rain.chapter1.demo3;

/**
 * description: 通过demo2中实现Runnable接口的匿名内部类方式创建线程。
 * @author 任伟
 * @date 2018/4/20 10:59
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 10; i++){
                    System.out.println("t3 run....【" + i + "】");
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread run...【" + i + "】");
        }
    }
}
