package jvm.gc;

/*
    -verbose:gc -Xmx200M -Xmn50M -XX:TargetSurvivorRatio=60 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:MaxTenuringThreshold=3

 -verbose:gc -Xmx200M -Xmn50M
 -XX:TargetSurvivorRatio=60  Survivor空间占比已经达到60%了,则要重新计算GC的阈值
 -XX:+PrintTenuringDistribution  显示对象age信息
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps  打印时间戳
 -XX:+UseConcMarkSweepGC 在老年代使用CMS
 -XX:+UseParNewGC  新生代使用ParNewGC
 -XX:MaxTenuringThreshold=3

 -verbose:gc -Xmx200M -Xmn50M
 -XX:TargetSurvivorRatio=60
 -XX:+PrintTenuringDistribution
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps
 -XX:+UseConcMarkSweepGC
 -XX:+UseParNewGC
 -XX:MaxTenuringThreshold=3
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("111111");

        myGc();
        Thread.sleep(1000);

        System.out.println("222222");

        myGc();
        Thread.sleep(1000);

        System.out.println("333333");

        myGc();
        Thread.sleep(1000);

        System.out.println("444444");

        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);

        System.out.println("555555");

        myGc();
        Thread.sleep(1000);

        System.out.println("666666");

        System.out.println("hello world");
    }

    private static void myGc() {
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
