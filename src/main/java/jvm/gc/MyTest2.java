package jvm.gc;

/*
    PretenureSizeThreshold：设置对象超过多大时直接在老年代进行分配

 -verbose:gc
 -Xms20M
 -Xms20M
 -Xmn10M
 -XX:+PrintGCDetails
 -XX:SurvivorRatio=8
 -XX:PretenureSizeThreshold=4194304 //当创建的大小超过这个指定值时,被创建的对象不会在新生代,而是直接在老年代创建
 -XX:+UseSerialGC   //配置此参数时, 上面PretenureSizeThreshold这个参数才生效

 */

public class MyTest2 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc = new byte[10 * size];

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
