package cn.rain.chapter1.demo3;

import java.util.concurrent.Callable;

/**
 * @author 左边
 * @date 2022/2/14 9:20 下午
 */
public class Mythread3 implements Callable<Integer> {
    @Override
    public Integer call() {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " --> name : " + Thread.currentThread().getName());
            a++;
        }
        return a;
    }
}
