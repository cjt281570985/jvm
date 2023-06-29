package jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-11-25 10:25
 */
public class MyTest17 extends ClassLoader{

  private String classLoaderName;

  private String path;

  private String feleExtension = ".class";

  public MyTest17(String classLoaderName) {
    super(); //将系统类加载器当做该类加载的父加载器
    this.classLoaderName = classLoaderName;
  }

  public MyTest17(ClassLoader parent, String classLoaderName) {
    super(parent);// 显示指定该类加载器父加载器
    this.classLoaderName = classLoaderName;
  }
  public void setPath(String path) {
    this.path = path;
  }

  @Override
  protected Class<?> findClass(String className) throws ClassNotFoundException {
    System.out.println("className: " + className);
    System.out.println("classLoaderName: " + this.classLoaderName);

    byte[] data = this.loadClassData(className);
    return this.defineClass(className, data, 0, data.length);
  }

  private byte[] loadClassData(String className){
    byte[] data = null;
    InputStream is = null;
    ByteArrayOutputStream baos = null;

    System.out.println("loadClassData..........");
    try {
      className = className.replace(".", "/");
      String fileName = this.path + className + this.feleExtension;
      System.out.println("fileName: " + fileName);
      is = new FileInputStream(new File(fileName));
      baos = new ByteArrayOutputStream();
      int ch = 0;
      while (-1 != (ch = is.read())) {
        baos.write(ch);
      }
      data = baos.toByteArray();
    } catch (Exception e) {

    }finally {
      try {
        is.close();
        baos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return data;
  }


  public static void main(String[] args) throws Exception {

    MyTest17 loader1 = new MyTest17("loader17");
    //myTest.setPath("E:\\gitSpace\\jdk8\\out\\production\\classes\\");
    //   /Users/jimmy/code/gitSpace/jvm/out/production/classes
    //myTest.setPath("/Users/jimmy/code/gitSpace/jvm/out/production/classes/");
    loader1.setPath("/Users/jimmy/data/tmp/mytest19/");

    Class<?> clazz = loader1.loadClass("jvm.classloader.MyTest2"); //classpath目录下的MyTest2.class要删除
    System.out.println("class: " + clazz);
    System.out.println("class.hashCode: " + clazz.hashCode());
    Object object = clazz.newInstance();
    System.out.println(object);
    System.out.println("--------------------------------");

    //MyTest17 loader2 = new MyTest17("loader177");
    MyTest17 loader2 = new MyTest17(loader1 , "loader177");
    //myTest.setPath("/Users/jimmy/code/gitSpace/jvm/out/production/classes/");
    loader2.setPath("/Users/jimmy/data/tmp/");

    Class<?> clazz2 = loader2.loadClass("jvm.classloader.MyTest2");
    System.out.println("class2: " + clazz2);
    System.out.println("class2.hashCode: " + clazz2.hashCode());
    Object object2 = clazz2.newInstance();
    System.out.println(object2);
  }
}
