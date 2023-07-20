package jvm.gc;

/*
    PSYoungGen：Parallel Scavenge（新生代垃圾收集器）
    ParOldGen：Parallel Old （老年代垃圾收集器）
 */

public class MyTest1 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        byte[] myAlloc4 = new byte[3 * size];

        System.out.println("hello world");
    }
}
// -verbose:gc -Xms20M(堆新生代和老年代初始大小20M)  -Xms20M(新生代和老年代总大小20M) -Xmn10M(堆当中的新生代10M)
//-XX:+PrintGCDetails   -XX:SurvivorRatio=8
/**
 -verbose:gc
 -Xms20M  //堆容量初始大小
 -Xms20M  //堆容量最大值
 -Xmn10M
 -XX:+PrintGCDetails
 -XX:SurvivorRatio=8


 **/