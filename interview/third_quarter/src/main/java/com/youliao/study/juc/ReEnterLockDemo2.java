package main.java.com.youliao.study.juc;

/**
 * @Author Dali
 * @Date 2021/9/2 13:56
 * @Version 1.0
 * @Description： 可重入锁:同步方法
 */
public class ReEnterLockDemo2 {

    public synchronized void m1() {
        System.out.println("可重入锁:同步方法===外层调用");
        m2();
    }

    public synchronized void m2() {
        System.out.println("可重入锁:同步方法===中层调用");
        m3();
    }

    public synchronized void m3() {
        System.out.println("可重入锁:同步方法===内层调用");
    }


    public static void main(String[] args) {
        new ReEnterLockDemo2().m1();
    }
}
