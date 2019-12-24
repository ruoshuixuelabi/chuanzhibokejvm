package cn.itcast.jvm.t1.stack;

/**
 * 局部变量的线程安全问题
 */
public class Demo1_17 {
    public static void main(String[] args) {
        //主线程在修改StringBuilder对象
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        //子线程也在修改
        new Thread(()-> m2(sb)).start();
    }

    /**
     * 不会有线程安全的问题
     * sb是线程内的私有变量,不可能被其他的线程访问到
     */
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    /**
     * 不是线程安全的,因为StringBuilder是传参进来的
     * 代表有可能有其他的线程访问到它
     * @param sb
     */
    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    /**
     * 不是线程安全的
     * 虽然StringBuilder是方法内的局部变量
     * 但是当成方法的返回值返回了
     * @return
     */
    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }
}
