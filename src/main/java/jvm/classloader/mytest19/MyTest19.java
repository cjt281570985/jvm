package jvm.classloader.mytest19;

import jvm.classloader.MyTest17;

/**
 * 关于命名空间说明
 *
 * 子加载器所加载的类 能  访问父加载器所加载的类
 * 父加载器所加载的类 不能 访问子加载器所加载的类
 *
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-25 10:25
 */
public class MyTest19 {

  public static void main(String[] args) throws Exception {

    MyTest17 load = new MyTest17("loader1");
    Class<?> clazz = load.loadClass("jvm.classloader.mytest19.MySimple");
    System.out.println("class: " + clazz.hashCode());

    Object object = clazz.newInstance();
  }
}
