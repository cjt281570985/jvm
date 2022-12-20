package jvm.classloader;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2022-12-20 上午10:51
 */
public class T {

    public static void main(String[] args) {
        System.out.println(MyParent222.str);
        System.out.println(MyParent222.d);
        System.out.println(MyParent222.dd);
    }
}


class MyParent222{
    public static final String str = "hello world";

    public static final int d = 1;
    public static final float dd = 2;

    static {
        System.out.println("MyParent2 static block");
    }
}