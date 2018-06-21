package cn.rain.chapter3.demo1;

import cn.rain.chapter3.entity.User;

/**
 * description: 线程间通信的生产者线程
 *
 * @author 任伟
 * @date 2018/6/20 22:24
 */
public class ProducerThreadDemo1 implements Runnable{

    private User user;

    ProducerThreadDemo1(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        // 使用count来控制生产哪个user
        int count = 0;
        while (true) {
            if (count == 0) {
                user.setUsername("大力");
                user.setGender("男");
            }else {
                user.setUsername("小兰");
                user.setGender("女");
            }
            count = (count + 1) % 2;
        }
    }
}
