package jvm.classloader.mytest19;

import jvm.classloader.MyTest18;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-25 10:25
 */
public class MyTest20 {

  //关于命名空间说明
  //子加载器所加载的类能够访问父加载器所加载的类
  //父加载器所加载的类无法访问子加载器所加载的类

  public static void main(String[] args) throws Exception {

    MyTest18 load = new MyTest18("loader1");
    load.setPath("c:\\");
    Class<?> clazz = load.loadClass("jvm.classloader.mytest19.MySimple");
    System.out.println("class: " + clazz.hashCode());

    Object object = clazz.newInstance();
  }
}
