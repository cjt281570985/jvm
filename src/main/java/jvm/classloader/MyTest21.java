package jvm.classloader;

import java.lang.reflect.Method;

/**
 * 类加载器的双亲委托模型的好处:
 *
 * 1.可以确保Java核心库的类型安全:所有的Java应用都至少会引用java.lang.Object,也就是说在运行期,
 *   java.lang.Object这个类会被加载到JAVA虚拟机中;如果这个加载过程是由JAVA应用自己的类加载器所完成的,
 *   那么可盈会在JVM中存在多个版本的java.lang.Object类,而且这些类之间还是不兼容,相互不可见的(正是命名空间在发挥作用).
 *   借助于双亲委托机制,JAVA核心类库中的加载工作都是由启动类的加载器来统一完成,从而确保JAVA应用所使用的都是同一个版本的JAVA核心类库,相互兼容
 * 2.可以确保JAVA核心类库所提供的类不会被自定义的类所代替
 * 3.不同的类加载器可以为相同名称的类创建额外的命名空间.相同名称的类可以并存在JAVA虚拟机中,只需要用不同的类加载器来加载他们即可.
 *   不同的类加载器所加载的类之间是不兼容的,相当于在JAVA虚拟机内部创建了一个又一个相互隔离的JAVA类空间,这类技术在很多框架中都得到实际应用.
 *
 *
 * @Author: jimmy
 * @Description:
 * @Date: Created 2023-06-07 下午6:33
 */
public class MyTest21 {

  public static void main(String[] args) throws Exception {
    MyTest17 load1 = new MyTest17("load1");
    MyTest17 load2 = new MyTest17("load2");
    load1.setPath("/Users/jimmy/data/tmp/");
    load2.setPath("/Users/jimmy/data/tmp/");

    Class<?> class1 = load1.loadClass("jvm.classloader.MyPerson");
    Class<?> class2 = load2.loadClass("jvm.classloader.MyPerson");

    System.out.println(class1 == class2);

    Object object1 = class1.newInstance();
    Object object2 = class2.newInstance();

    Method method = class1.getMethod("setMyPerson", Object.class);
    method.invoke(object1, object2);
  }

}
