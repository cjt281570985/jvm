package jvm.reference;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Date;

/*
    1. 为什么PhantomReference的get方法直接返回null。
    2. 为什么PhantomReference的构造方法只有接收两个参数（referent与queue）的这一种形式，而没有只接收referent
       这唯一参数的构造方法

    当我们将一个对象封装到PhantomReference中时，这就意味着我们将永远也无法再访问到这个对象了，因为PhantomReference的
    get方法永远都会返回null；PhantomReference的主要作用并不在于可以让我们获取到其中封装的referent，而是在于当垃圾收集
    器回收其referent时，这个PhantomReference会被放置到与其关联的队列中，并且得到相应的通知，这就是PhantomReference存在
    的唯一目的。
 */

public class MyTest4 {

    public static void main(String[] args) {
        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Date> phantomReference = new PhantomReference<>(date, referenceQueue);

        System.out.println(phantomReference.get());
    }
}
