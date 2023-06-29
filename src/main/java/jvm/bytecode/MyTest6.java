package jvm.bytecode;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2023-06-28 下午7:29
 */
public class MyTest6 {

  public static void main(String[] args) {
    Fruit apple = new Apple();
    Fruit orange = new Orange();

    apple.test();
    orange.test();
  }

}

class Fruit {

  public void test() {
    System.out.println("Fruit");
  }
}

class Apple extends Fruit {
  @Override
  public void test() {
    System.out.println("Apple");
  }
}

class Orange extends Fruit {
  @Override
  public void test() {
    System.out.println("Orange");
  }
}