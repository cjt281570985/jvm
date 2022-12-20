package jvm.classloader;

/**
 * 对于数组实例来说,其类型是由JVM运行期动态生成的,表示为class [Ljvm.classloader.MyParent4
 * 这种形式,动态生成的类型,其父类就是Object
 *
 * 对于数组来说,JavaDoc经常将构成数组的元素为Component,实际上就是将数组降低一个维度后来的类型.
 *
 * 助记符:
 * anewarray: 表示创建一个引用类型的(如类,接口,数组)数组,并将其引用压入栈顶
 * newarray:  表示创建一个指定的原始类型(如int, float, char等)的数组,并将其引用值压入栈顶
 */
public class MyTest4 {

    //  javap -c jvm.classloader.MyTest4

    public static void main(String[] args) {

        //MyParent4 myParent4 = new MyParent4();
        MyParent4[] arr = new MyParent4[1];
        System.out.println(arr.getClass()); //class [Ljvm.classloader.MyParent4

        MyParent4[][] arr2 = new MyParent4[1][1];
        System.out.println(arr2.getClass()); //class [[Ljvm.classloader.MyParent4;

        System.out.println(arr.getClass().getSuperclass()); //class java.lang.Object
        System.out.println(arr2.getClass().getSuperclass()); //class java.lang.Object

        System.out.println("===================");

        int[] ints = new int[1];
        System.out.println(ints.getClass()); //class [I
        System.out.println(ints.getClass().getSuperclass()); //class java.lang.Object

        char[] chars = new char[1];
        System.out.println(chars.getClass()); //class [C

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass()); //class [Z

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass()); //class [B

    }
}


class MyParent4 {

    static {
        System.out.println("MyParent4 static block");
    }
}