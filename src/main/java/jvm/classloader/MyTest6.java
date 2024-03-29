package jvm.classloader;


public class MyTest6 {

  public static void main(String[] args) {

    Singleton singleton = Singleton.getInstance();

    System.out.println("counter1: " + Singleton.counter1);
    System.out.println("counter2: " + Singleton.counter2);


  }

}

class Singleton {

  public static int counter1 = 1;


  private static Singleton singleton = new Singleton();

  public Singleton() {
    counter1++;
    counter2++;//准备阶段的重要意义

    System.out.println(counter1);
    System.out.println(counter2);
  }

  public static int counter2 = 0;

  public static Singleton getInstance() {
    return singleton;
  }

}
