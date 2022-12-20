package jvm.classloader;

/**
 * 当一个接口在初始化时,并不要求父接口都完成初始化
 * 只有在真正使用到父接口的时候(如引用接口中定义的常量时)才会初始化
 * <p>
 * 此例子 看简书详细介绍 https://www.jianshu.com/p/172524bf59fa
 */
public class MyTest51 {
    public static void main(String[] args) {
        System.out.println(MyChild51.b);
    }
}

//接口中的常量 默认是 final, 类中的常量如果没定义为final那它就不是final
interface MyParent51 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent51  new thread...");
        }
    };
}

interface MyChild51 extends MyParent51 {
    public static int b = 6;
}
