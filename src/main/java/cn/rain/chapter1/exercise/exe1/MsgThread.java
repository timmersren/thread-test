package cn.rain.chapter1.exercise.exe1;

import java.util.List;

/**
 * description: 为一组用户发送消息的线程，需要传入一个用户组。
 * @author 任伟
 * @date 2018/4/20 13:46
 */
public class MsgThread implements Runnable {

    private List<User> userList;

    public MsgThread(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void run() {
        for (User user : userList) {
            System.out.println("正在给" + user.getUsername() + "发送信息..." + Thread.currentThread().getName());
        }
        System.out.println();
    }
}
