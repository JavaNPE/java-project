package jvm.gcroots;

/**
 * @Author Dali
 * @Date 2021/5/27 12:06
 * @Version 1.0
 * @Description： 那些对象可以当做GC Roots对象呢？（试讲）
 * 虚拟机栈（栈帧中的局部变量区，也叫做局部变量表）中的引用对象
 * 方法区中的类静态属性引用的对象
 * 方法区中常量引用的对象
 * 本地方法栈中的JNI（Native方法）的引用对象
 */
public class GDRootDemo {
    private byte[] byteArray = new byte[100 * 1024 * 1024];

    public static void m1() {

        // 方法区中的类静态属性引用的对象
        // private static GCRootDemo2 t2;

        // 方法区中的常量引用，GC Roots 也会以这个为起点，进行遍历
        // private static final GCRootDemo3 t3 = new GCRootDemo3(8);


        //第一种：虚拟机栈中的引用对象
        GDRootDemo t1 = new GDRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }

    public static void main(String[] args) {
        m1();
    }
}
