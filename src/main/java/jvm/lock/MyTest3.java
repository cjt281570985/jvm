package jvm.lock;

/*
    Java锁的分类维度：

    1. 共享角度：多个线程是否可以共享同一把锁，能：共享锁，不能：排他锁。
    2. 同一个线程在执行过程中是否可以获取到同一把锁，能：可重入锁，不能：非可重入锁。
    3. 资源角度，线程在执行更新操作时，是否需要利用锁来锁住同步资源，需要：悲观锁，不需要：乐观锁（CAS）。
    4. 多线程在竞争锁资源时是否需要进行排队等待，排队：公平锁，不排队：非公平锁。
    5. 当线程尝试锁住同步资源，但却失败了，那么线程是否需要阻塞，阻塞，不阻塞：自旋，如果线程在自旋过程当中一直没有获取到同步资源，那么
       该线程最终还是会被阻塞，进入到内核态（自适应自旋）。
    6. 多线程在竞争同步资源时在过程中的区别，无锁：多线程会同时进行资源的修改，并且不锁住资源，在这种情况下，某一个时刻只会有一个线程对
       资源的修改是成功的，其他线程均会失败，失败的线程则会进行不断的重试（CAS）；同一个线程在执行时，如果遇到了同步资源，那么它会自动获取
       到这个锁资源，而不必进行其他任何操作（偏向锁）；多个线程同时在尝试竞争锁资源，同一时刻，只会有一个线程能够获取到锁，那么其他没有获取
       到锁的线程就会进行自旋等待锁的释放（轻量级锁）；多个线程同时在尝试竞争锁资源，并且进行了自旋，但经过一段时间后，线程依然无法获取到锁
       资源，这个时候，没有获取到锁资源的线程将会进入到阻塞状态，等待CPU的唤醒（重量级锁）


    关于悲观锁与乐观锁的适用场景：

    乐观锁：非常适合于读操作非常多的场景，因为本身不加锁，所以可以使得操作的性能有非常明显的提升。
    悲观锁：非常适合于写操作非常多的场景，因为首先需要对资源进行加锁操作，所以完全可以保证写入操作的正确和健壮。

    CAS （Compare And Swap），比较与交换

    CAS算法本质上涉及到三个数字：

    1. 需要进行读写的内存值V
    2. 需要进行比较的值A
    3. 需要进行写入的新的值B

    比较与更新本质上是一个原子操作，它在CPU层面上是一个指令来完成的。

    CAS的主要问题：ABA。


    自旋：

    减少CPU状态的切换，从而减少线程在用户态与内核态之间的切换，从而达到提升效率的目的。

    自旋会有一个上限（阈值），默认情况下，线程会自旋10次，PreBlockSpin参数来设置线程默认的自旋次数。

    自旋锁是在JDK 1.4中引入的，我们可以通过UseSpinning来开启自旋，从JDK 1.6开始，自旋锁是默认开启的，同时该版本的JDK又引入了
    适应性自旋锁。


    无锁、偏向锁、轻量级锁与重量级锁：

    这几种锁本质上都是针对于synchronized关键字的。

    关于Java对象头：

    Klass Pointer：
    Mark Word：

    1. 无锁标记
    2. 偏向锁标记
    3. 轻量级锁标记
    4. 重量级锁标记
    5. GC标记

    锁升级的功能主要是依赖于Mark Word中的锁标志位与是否是偏向锁来达成的；synchronized关键字其实就是从偏向锁开始，然后升级为轻量级锁，
    最终升级为重量级锁。

    Monitor中拥有一个owner字段，用来标识持有该锁的线程的唯一标识，表示这个锁被该线程所持有。

    synchronized本质上就是通过Monitor来实现的。Monitor本质上又是依赖于底层操作系统的互斥锁（mutex lock）来实现的。


    偏向锁：针对于同一个线程访问一个同步代码块的场景。减少了频繁获取与释放锁的代价。 UseBiasedLocking=false
    轻量级锁：JVM会在Stack Frame中建立一个名为Lock Record的空间，用于存储锁对象目前的Mark Word的副本，同时它会将对象头中的
            Mark Word复制到锁记录中；如果成功，那么JVM会将对象的Mark Word更新为指向Lock Record的指针，同时会将Lock Record
            中的owner指针指向对象的Mark Word。如果该操作成功，就表示线程拥有了对象的锁。这样，对象就会处于轻量级锁的状态之中。
            轻量级锁就会升级成为重量级锁。
    重量级锁：是锁的最终状态，等待的线程会进入到阻塞状态（内核态）。

    JIT来实现一些优化措施：逃逸分析的技术。
    锁粗化：
    减小锁的粒度：


    公平锁与非公平锁：

    ReentrantLock提供了公平锁与非公平锁的实现，它默认使用的是非公平锁。

    可重入锁与非可重入锁：

    Java中的ReentrantLock与synchronized都是可重入锁，它最大的优势在于可以防止死锁的出现。

    共享锁与排他锁：

    AQS中：高16位表示读状态、低16位表示写状态。

 */


public class MyTest3 {


}