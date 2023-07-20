package jvm.lock;

/*
    对于同步方法的字节码来说，在反编译后的字节码中并没有出现monitorenter与monitorexit相关的指令，而是出现了一个ACC_SYNCHRONIZED标记。

    本质上，JVM使用了ACC_SYNCHRONIZED访问标记来判断某个方法是否是一个同步方法。

    当方法调用时，调用指令会先检查该方法是否拥有ACC_SYNCHRONIZED访问标记。如果发现了该标记，那么执行的线程将会首先持有Monitor对象，
    接下来再去执行方法；在该方法运行期间，其他任何线程都将无法获取到该Monitor对象，当方法执行完毕后，线程会释放掉所持有的Monitor对象。

    那么线程所持有的Monitor对象又是什么呢？

    1. 如果被synchronized修饰的方法是普通的实例方法，那么该Monitor对象就是当前被调用方法所在的那个对象。
    2. 如果被synchronized修饰的方法是静态方法，那么该Monitor对象就是当前类所对应的Class对象。
 */


public class MyTest2 {

    public synchronized void myMethod() {
        System.out.println("hello world");
    }
}
