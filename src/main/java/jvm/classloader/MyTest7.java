package jvm.classloader;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-10-02 11:05
 */
public class MyTest7 {


  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("java.lang.String");
    System.out.println(clazz.getClassLoader()); // null

    Class<?> clazzD = Class.forName("jvm.classloader.D");
    System.out.println(clazzD.getClassLoader());  // sun.misc.Launcher$AppClassLoader@18b4aac2
  }
}

class D {
}