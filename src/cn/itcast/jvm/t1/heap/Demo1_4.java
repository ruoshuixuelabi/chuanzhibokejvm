package cn.itcast.jvm.t1.heap;

/**
 * 演示堆内存
 *
 * @author dep
 */
public class Demo1_4 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1...");
        Thread.sleep(30000);
        // 创建了一个10 Mb的数组
        byte[] array = new byte[1024 * 1024 * 10];
        System.out.println("2...");
        Thread.sleep(20000);
        //清理数组的内存占用情况
        array = null;
        //告诉虚拟机执行垃圾回收，然后看看垃圾回收之后的堆内存占用情况
        System.gc();
        System.out.println("3...");
        Thread.sleep(1000000L);
    }
}
