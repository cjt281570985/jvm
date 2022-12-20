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
public class MyTest16 extends ClassLoader{

  private String classLoaderName;

  private String feleExtension = ".class";

  public MyTest16(String classLoaderName) {
    super(); //将系统类加载器当做该类加载的父加载器
    this.classLoaderName = classLoaderName;
  }

  public MyTest16(ClassLoader parent, String classLoaderName) {
    super(parent);// 显示指定该类加载器父加载器
    this.classLoaderName = classLoaderName;
  }

  @Override
  public String toString() {
    return "[" + this.classLoaderName + "]";
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

    try {
      //this.classLoaderName = this.classLoaderName.replace(".", "//");
      is = new FileInputStream(new File(className + this.feleExtension));
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

  public static void test(ClassLoader classLoader) throws Exception{
    Class<?> clazz = classLoader.loadClass("jvm.classloader.MyTest1");
    Object object = clazz.newInstance();
    System.out.println(object);
    System.out.println(object.getClass().getClassLoader());
  }

  public static void main(String[] args) throws Exception {

    MyTest16 myTest16 = new MyTest16("loader15");
    test(myTest16);
  }

}
