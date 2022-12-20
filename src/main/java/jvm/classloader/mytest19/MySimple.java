package jvm.classloader.mytest19;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-12-02 16:30
 */
public class MySimple {

  public MySimple() {
    System.out.println("MySimple loaded by: " + this.getClass().getClassLoader());

    new MyCat();

    System.out.println("----------in mysimple mycat : " + MyCat.class);
  }

}
