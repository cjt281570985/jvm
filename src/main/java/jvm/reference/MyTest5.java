package jvm.reference;

public class MyTest5 {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("hello");
        threadLocal.set("world");

        System.out.println(threadLocal.get());
    }
}
