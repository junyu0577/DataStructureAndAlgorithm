package com.github.junyu.solution.leetCode.medium.other;

import java.util.concurrent.Semaphore;

public class _1115_Print_FooBar_Alternately {

    /*Suppose you are given the following code:

    class FooBar {
        public void foo() {
            for (int i = 0; i < n; i++) {
                print("foo");
            }
        }

        public void bar() {
            for (int i = 0; i < n; i++) {
                print("bar");
            }
        }
    }
    The same instance of FooBar will be passed to two different threads. Thread A will call foo() while
    thread B will call bar(). Modify the given program to output "foobar" n times.



    Example 1:

    Input: n = 1
    Output: "foobar"
    Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other
     calls bar(). "foobar" is being output 1 time.
            Example 2:

    Input: n = 2
    Output: "foobarfoobar"
    Explanation: "foobar" is being output 2 times.*/

    /**
     * 交替打印foobar
     *
     */
    class FooBar {
        private int n;
        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized (this) {
                for (int i = 0; i < n; i++) {
                    bar.acquire();
                    printBar.run();
                    foo.release();
                }
            }
        }
    }

//    /**
//     * 交替打印foobar
//     * 在各自的for循环中通过变量isPrintFirst去决定要阻塞哪一边，未阻塞的执行完毕后修改变量值并唤醒另一个阻塞的线程。
//     */
//    class FooBar {
//        private int n;
//        private volatile boolean isPrintFirst;
//
//        public FooBar(int n) {
//            this.n = n;
//        }
//
//        public void foo(Runnable printFoo) throws InterruptedException {
//
//            synchronized (this) {
//                for (int i = 0; i < n; i++) {
//                    while (isPrintFirst)
//                        this.wait();
//
//                    printFoo.run();
//                    isPrintFirst  = true;
//                    this.notify();
//                }
//            }
//        }
//
//        public void bar(Runnable printBar) throws InterruptedException {
//            synchronized (this) {
//                for (int i = 0; i < n; i++) {
//                    while (!isPrintFirst)
//                        this.wait();
//
//                    printBar.run();
//                    isPrintFirst = false;
//                    this.notify();
//                }
//            }
//        }
//    }
}
