package jvm.classloader.mytest19;

import jvm.classloader.MyTest17;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-25 10:25
 */
public class MyTest19_1 {

  public static void main(String[] args) throws Exception {

    MyTest17 load = new MyTest17("loader1");
    load.setPath("/Users/jimmy/data/tmp/");

    Class<?> clazz = load.loadClass("jvm.classloader.mytest19.MySimple");
    System.out.println("class: " + clazz.hashCode());

    Object object = clazz.newInstance();
  }
}
