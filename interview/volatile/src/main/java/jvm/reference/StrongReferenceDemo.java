package jvm.reference;

/**
 * @Author Dali
 * @Date 2021/5/28 8:29
 * @Version 1.0
 * @Description: 强引用
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object(); //这样定义的就是默认的强引用
        Object obj2 = obj1;     //obj2引用赋值
        obj1 = null;    //置空
        System.gc();
        System.out.println();
        System.out.println(obj2);
    }
}
