package jvm.gc;

/**
 * @Author Dali
 * @Date 2021/5/27 12:48
 * @Version 1.0
 * @Description: 60_ JVM的XX参数之布尔类型 https://www.bilibili.com/video/BV18b411M7xz?p=60&spm_id_from=pageDriver
 * <p>
 * https://www.bilibili.com/video/BV18b411M7xz?p=65&spm_id_from=pageDriver
 */
public class HelloGC {
    public static void main(String[] args) throws Exception {
        System.out.println("**********HelloGC");
        Thread.sleep(Integer.MAX_VALUE);

     /*   // 返回Java虚拟机中内存的总量
        long totalMemory = Runtime.getRuntime().totalMemory();

        // 返回Java虚拟机中试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double) 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");*/
    }
}
