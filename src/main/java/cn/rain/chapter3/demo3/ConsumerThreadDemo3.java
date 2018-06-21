package cn.rain.chapter3.demo3;


import cn.rain.chapter3.entity.User3;

/**
 * description: 消费者线程，使用wait-notify机制。
 *
 * @author 任伟
 * @date 2018/6/20 23:02
 */
@SuppressWarnings("all")
public class ConsumerThreadDemo3 implements Runnable {

    private User3 user;

    ConsumerThreadDemo3(User3 user) {
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (user) {
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!user.isFlag()) {
                    try {
                        user.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String username = user.getUsername();
                String gender = user.getGender();
                System.out.println("消费者读取：" + username + "---" + gender);
                user.setFlag(false);
                user.notify();
            }
        }
    }
}
