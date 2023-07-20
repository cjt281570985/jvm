package jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;

/*
    Reference Queue（引用队列）的设计目的在于让我们能够知道或是识别出垃圾收集器所执行的动作。
 */

public class MyTest2 {

    public static void main(String[] args) {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue();
        SoftReference<Date> softReference = new SoftReference(date, referenceQueue);

        System.out.println(softReference.get());

        date = null; //如果一个对象是软引用可达的，那么该对象一般来说会持续（或存活）时间更久一些。

        System.gc();

        System.out.println(softReference.get());
    }
}
