package cn.rain.chapter2.demo7;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/6/20 17:08
 */
public class VolatileThreadMain {
    public static void main(String[] args) throws InterruptedException {
        VolatileThread volatileThread = new VolatileThread();
        Thread thread = new Thread(volatileThread);
        System.out.println("读取flag的值为：" + volatileThread.isFlag());
        thread.start();
        Thread.sleep(3000);
        volatileThread.setFlag(false);
        System.out.println("flag的值已经更改为： false");
        System.out.println("读取flag的值为：" + volatileThread.isFlag());
    }
}
