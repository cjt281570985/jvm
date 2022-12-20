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
public class MyTest18 extends ClassLoader{

  private String classLoaderName;

  private String path;

  private String feleExtension = ".class";

  public MyTest18(String classLoaderName) {
    super(); //将系统类加载器当做该类加载的父加载器
    this.classLoaderName = classLoaderName;
  }

  public MyTest18(ClassLoader parent, String classLoaderName) {
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

    System.out.println("loadClassData.222.........");
    try {
      className = className.replace(".", "\\");
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

    MyTest18 myTest = new MyTest18("loader18");
    //myTest.setPath("E:\\gitSpace\\jdk8\\out\\production\\classes\\");
    myTest.setPath("c:\\");

    Class<?> clazz = myTest.loadClass("jvm.classloader.MyTest2");
    System.out.println("class: " + clazz);
    System.out.println("class.hashCode: " + clazz.hashCode());
    Object object = clazz.newInstance();
    System.out.println(object);
    System.out.println("--------------------------------");

    MyTest18 myTest2 = new MyTest18(myTest, "loader18");
    //myTest.setPath("E:\\gitSpace\\jdk8\\out\\production\\classes\\");
    myTest2.setPath("c:\\");

    Class<?> clazz2 = myTest2.loadClass("jvm.classloader.MyTest2");
    System.out.println("class2: " + clazz2);
    System.out.println("class2.hashCode: " + clazz2.hashCode());
    Object object2 = clazz2.newInstance();
    System.out.println(object2);

    System.out.println("--------------------------------");

    MyTest18 myTest3 = new MyTest18(myTest2, "loader19");
    //myTest.setPath("E:\\gitSpace\\jdk8\\out\\production\\classes\\");
    myTest3.setPath("c:\\");

    Class<?> clazz3 = myTest3.loadClass("jvm.classloader.MyTest2");
    System.out.println("class3: " + clazz3);
    System.out.println("class3.hashCode: " + clazz3.hashCode());
    Object object3 = clazz3.newInstance();
    System.out.println(object3);
  }
}
