package cn.rain.chapter1.demo2;

/**
 * description: 线程创建的第二种方式--实现Runnable接口
 * @author 任伟
 * @date 2018/4/20 10:51
 */
public class Mythread2 implements Runnable{

    @Override
    public void run() {
        for (int i=0; i < 10; i++){
            System.out.println("t2 run....【" + i + "】");
        }
    }
}
