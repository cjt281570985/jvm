package jvm.classloader.mytest19;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-12-02 16:30
 */
public class MyCat {

  public MyCat() {
    System.out.println("MyCat loaded by: " + this.getClass().getClassLoader());

    System.out.println("-----------in mycat mysimple: " + MySimple.class);
  }

}
