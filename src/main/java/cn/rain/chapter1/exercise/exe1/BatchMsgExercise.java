package cn.rain.chapter1.exercise.exe1;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 练习：模拟通过多线程的方式给1000个用户分批发送消息。
 * 实现步骤：
 * 1.初始化用户，这里创建1000个User对象都装进List中。
 * 2.定义每条线程发送的消息数，这里设置为200。
 * 3.根据每条线程发送的消息数为用户进行分组，按照 总用户数÷每条线程发送数 向上取余，例如1020个用户，
 *   即 1020 / 200 = 5.1 --> 向上取余为6，故分6组。
 * 4.为每组用户都创建一条线程，然后为每个用户发送消息。
 *
 * 总结：这样做的好处是便于横向扩展，假如用户数增加，我们只需增加分组，然后为新的组开一条线程即可。
 *
 * @author 任伟
 * @date 2018/4/20 13:28
 */
public class BatchMsgExercise {
    public static void main(String[] args) {
        // 1.初始化（创建）用户
        List<User> userList = initUsers(1000);
        // 2.定义每条线程发送的消息数
        int threadMessageCount = 200;
        // 3.为用户分组
        List<List<User>> pageUserList = ListUtils.splitList(userList, threadMessageCount);
        // 4.遍历所有的用户组，为每组用户创建一条线程发送消息
        for (int i = 0; i < pageUserList.size(); i++) {
            //获取第i组用户
            List<User> lstUser = pageUserList.get(i);
            //创建一条线程为该组用户发送消息
            MsgThread msgThread = new MsgThread(lstUser);
            Thread thread = new Thread(msgThread, "线程" + (i+1));
            thread.start();
        }
    }
    private static List<User> initUsers(int num){
        List<User> userList = new ArrayList<>(num);
        for (int i=0; i<num; i++){
            userList.add(new User("name:" + i, i));
        }
        return userList;
    }



}
