package jvm.classloader;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2023-06-09 下午4:59
 */
public class MyTest22 implements Runnable {

  private Thread thread;

  public MyTest22() {
    thread = new Thread(this);
    thread.start();
  }



  @Override
  public void run() {
    ClassLoader classLoader = this.thread.getContextClassLoader();

    this.thread.setContextClassLoader(classLoader);

    System.out.println("Class: " + classLoader.getClass());
    System.out.println("Parent: " + classLoader.getParent().getClass());
  }

  public static void main(String[] args) {
    new MyTest22();
  }

}
