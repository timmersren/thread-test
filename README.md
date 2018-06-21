# thread-test

## chapter1
1. 演示创建线程的三种方式 
2. 演示守护线程
3. 演示join的使用

## chapter2
1. 演示了多线程间的安全问题
2. 演示了通过线程间同步(synchronized)来解决线程间的安全问题
3. 演示了synchronized的三种用法：同步代码块、同步函数、静态同步函数
4. 验证同步函数使用的是this锁
5. 演示了死锁
6. 演示了使用volatile解决线程间可见性的问题

## chapter3
1. 演示线程间通信引发的线程安全问题
2. 通过前边所学的同步机制（synchronized）解决线程通信的安全问题
3. 通过wait-notify模型构建生产-消费模型
4. 使用J.U.C包下的Lock锁手动加锁替换synchronized进行同步。
5. 使用J.U.C包下的Condition的await-signal替换wait-notify机制。

## chapter4
主要演示J.U.C包中的常用类（暂未完成）。

## chapter5
演示线程池的使用及4中创建方式