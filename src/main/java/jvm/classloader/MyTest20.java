package jvm.classloader;

import sun.misc.Launcher;

/**
 * 在运行期,一个JAVA类是由该类的完全限定名(binary name, 二进制名)和用于加载该类的定义类加载器所共同决定
 * 如果同样名字(即相同的完全限定名)的类是由2个不同加载器所加载,那么这些类就是不同的,即便.class文件的字节码完全一样,
 * 并且从相同的位置加载也是如此
 *
 * 在Oracle的Hotspot实现属性sun.boot.class.path如果修改错了,则运行会出错
 *
 */
public class MyTest20 {

  public static void main(String[] args) {
    System.out.println(System.getProperty("sun.boot.class.path"));
    System.out.println(System.getProperty("java.ext.dirs"));
    System.out.println(System.getProperty("java.class.path"));

    /*
      内建于jvm中的启动类加载器会加载java.lang.ClassLoader以及其他JAVA平台类
      当jvm启动时,一块特殊的机器码会运行,它会加载扩展类加载器与系统类加载器,
      这块特殊的机器码叫做启动类加载器(Bootstrap).

      启动类加载器并不是JAVA类,而其他加载器则都是JAVA类,
      启动类加载器是特定于平台的机器指令, 它负责开启整个加载过程.
     */

    System.out.println(ClassLoader.class.getClassLoader()); //null

    //扩展类加载器与系统类加载器也是由启动类加载器所加载的
    System.out.println(Launcher.class.getClassLoader()); //null


    //从这去查看
    System.out.println(ClassLoader.getSystemClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2

  }

}
