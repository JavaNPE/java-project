package main.java.com.youliao.study.juc;

/**
 * @Author Dali
 * @Date 2021/9/2 13:41
 * @Version 1.0
 * @Description： 可重入锁:同步块
 * <p>
 * 可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。
 * <p>
 * 在一个synchronized修饰的方法或代码块的内部
 * 调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 */
public class ReEnterLockDemo1 {
    static Object objectlockA = new Object();

    public static void m1() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---外层调用");
            synchronized (objectlockA) {
                System.out.println(Thread.currentThread().getName() + "\t" + "---中层调用");
                synchronized (objectlockA) {
                    System.out.println(Thread.currentThread().getName() + "\t" + "---内层调用");
                }
            }
        }, "t1").start();
    }

    public static void main(String[] args) {
        m1();
    }
}
