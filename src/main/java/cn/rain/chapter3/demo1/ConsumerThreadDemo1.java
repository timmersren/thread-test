package cn.rain.chapter3.demo1;

import cn.rain.chapter3.entity.User;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/20 22:27
 */
public class ConsumerThreadDemo1 implements Runnable {

    private User user;

    ConsumerThreadDemo1(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String username = user.getUsername();
            String gender = user.getGender();
            System.out.println(username + "---" + gender);
        }
    }
}
