package jvm.lock;

/*
    当我们使用synchronized关键字来修饰同步代码块时，本质上在字节码层面上是通过monitorenter与monitorexit指令来实现
    同步的。当进入到monitorenter指令后，线程将会持有Monitor对象，当退出monitorexit后，线程将会释放掉该Monitor对象，
    在线程整个执行过程中，它会始终持有该Monitor对象的，这样就确保了共享资源的同步访问。

    Monitor对象到底是什么？

    当我们使用new关键字创建一个Java对象时，底层的JVM会自动为该创建的对象创建一个所谓的Object Header，并且将该Object Header
    附加到该对象上；本质上，Java中的每个对象在创建后，都会拥有一个与之相关联的Monitor对象，这也是为什么我们在使用synchronized
    关键字修饰同步代码块时，我们使用什么对象（如Object，String， Date）都可以的原因所在。

    Object Header里面包含了很多信息，如monitor信息，锁相关信息等。
 */


public class MyTest1 {

    private Object object = new Object();

    public void myMethod() {
        synchronized (object) {
            System.out.println("hello world");
        }
    }
}
