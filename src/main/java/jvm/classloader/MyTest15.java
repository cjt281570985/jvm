package jvm.classloader;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-24 23:45
 */
public class MyTest15 {

  public static void main(String[] args) {
    String[] arr = {"aaa", "bbb"};

    //数组的类加载器,与数组元素类型加载器是一样的
    System.out.println(arr.getClass().getClassLoader()); // null 表示启动类,根类加载器

    MyTest15[] myArr = new MyTest15[3];
    System.out.println(myArr.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2

    int[] intArr = new int[3];
    System.out.println(intArr.getClass().getClassLoader()); //null 表示没有,原生类型没有类加载器  与上面第一个不一样

  }

}
