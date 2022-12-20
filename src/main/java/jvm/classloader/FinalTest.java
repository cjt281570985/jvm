package jvm.classloader;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2021-05-03 14:37
 */
public class FinalTest {

    public static final  int x = 3;

    static {
        System.out.println("static.......");
    }

    {
        System.out.println("init.....");
    }

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
        new FinalTest();
    }

}
