package jvm.classloader.mytest19;

import jvm.classloader.MyTest18;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-25 10:25
 */
public class MyTest19 {

  public static void main(String[] args) throws Exception {

    MyTest18 load = new MyTest18("loader1");
    Class<?> clazz = load.loadClass("jvm.classloader.mytest19.MySimple");
    System.out.println("class: " + clazz.hashCode());

    //Object object = clazz.newInstance();
  }
}
