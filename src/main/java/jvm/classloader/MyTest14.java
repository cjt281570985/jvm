package jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import javax.print.DocFlavor;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-10-17 23:39
 */
public class MyTest14 {

  public static void main(String[] args) throws IOException {

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    System.out.println(classLoader);
    String resourceName = "jvm/classloader/MyTest12.class";
    Enumeration<URL> urls = classLoader.getResources(resourceName);
    while (urls.hasMoreElements()) {
      URL url = urls.nextElement();
      // file:/Users/jimmy/code/gitSpace/jvm/out/production/classes/jvm/classloader/MyTest12.class
      // file:/E:/gitSpace/jdk8/out/production/classes/jvm/classloader/MyTest12.class
      System.out.println(url);
    }
    System.out.println("--------------------------------");

    Class<?> clazz = MyTest14.class;
    Class<?> clazz1 = String.class;
    System.out.println(clazz.getClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
    System.out.println(clazz1.getClassLoader()); //Bootstrap在.. 统一用 null 表示

  }

}
