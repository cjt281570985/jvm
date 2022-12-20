package jvm.classloader;

/**
 * 当一个接口在初始化时,并不要求父接口都完成初始化
 * 只有在真正使用到父接口的时候(如引用接口中定义的常量时)才会初始化
 *
 * 此例子在第10有修复
 */
public class MyTest52 {

    public static void main(String[] args) {

        //System.out.println(MyChild52.b);
        System.out.println(MyParent5_2.thread);
    }

}
class MyGrandpa52 {
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa52  new thread...");
        }
    };
}
//接口中的常量 默认是 final, 类中的常量如果没定义为final那它就不是final
class MyParent52 extends MyGrandpa52{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent52  new thread...");
        }
    };
}
class MyChild52 extends MyParent52 {
    public static int b = 6;
}
interface MyGrandpa5_2 {
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa5_2  new thread...");
        }
    };
}
interface MyParent5_2 extends  MyGrandpa5_2{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5_2  new thread...");
        }
    };
}