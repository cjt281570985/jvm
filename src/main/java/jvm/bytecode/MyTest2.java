package jvm.bytecode;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2023-06-21 上午10:49
 */
public class MyTest2 {

  String str = "Welcome";

  private int x = 5;

  public static Integer in = 10;

  public static void main(String[] args) {
    MyTest2 myTest2 = new MyTest2();

    myTest2.setX(8);

    in = 20;
  }

  private synchronized void setX(int x) {
    this.x = x;
  }

  private void test(String str) {
    synchronized (str) {
      System.out.println("hello world");
    }
  }

  private synchronized static void test2() {

  }
}
