package jvm.classloader;


/**
 *
 在编译阶段,常量会被存入调用这个常量的那个方法所在的类的常量池中.
 本质上,调用类并没有直接引用到定义常量的类,因此并不会触发定义常量类的初始化
 注意:这里指的是将常量存放到了MyTest2的常量池中, 之后MyTest2与MyParent2就没有任何关系了
 甚至可以将MyParent2的class文件删除.

 如上: 常量str会存入到上面类MyTest2中常量池中

 助记符:
 ldc表示将int, float或是String类型的常量值从常量池中推送至栈顶
 bipush表示将单字节(-128 - 127)的常量值推送至栈顶
 sipush表示将一个短整形常量值(-32768 - 32767)推送至栈顶
 iconst_1表示将int类型数字1推送至栈顶(iconst_m1 - iconst_5)
 0 iconst_0   -1 iconst_m1
 com.sun.org.apache.bcel.internal.generic.ICONST.class
 com.sun.org.apache.bcel.internal.Constants.class
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        System.out.println(MyParent2.a);
        System.out.println(MyParent2.d);
        System.out.println(MyParent2.ss);
        System.out.println(MyParent2.sa);
    }
}
//查看反编译
//E:\gitSpace\jdk8\out\production\classes>javap -c jvm.classloader.MyTest2

class MyParent2{
    public static final String str = "hello world";
    public static final float a = 2;
    public static final int s = -1;
    public static final int ss = 128;
    public static final int sa = 127;

    public static final int d = 6;

    static {
        System.out.println("MyParent2 static block");
    }
}
