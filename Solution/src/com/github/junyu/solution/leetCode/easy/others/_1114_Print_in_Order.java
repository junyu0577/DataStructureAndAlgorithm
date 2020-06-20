package com.github.junyu.solution.leetCode.easy.others;

import java.util.concurrent.Semaphore;

public class _1114_Print_in_Order {

    /*Suppose we have a class:

    public class Foo {
        public void first() { print("first"); }
        public void second() { print("second"); }
        public void third() { print("third"); }
    }
    The same instance of Foo will be passed to three different threads. Thread A will call first(),
     thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure
      that second() is executed after first(), and third() is executed after second().



    Example 1:

    Input: [1,2,3]
    Output: "firstsecondthird"
    Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A
    alls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
    Example 2:

    Input: [1,3,2]
    Output: "firstsecondthird"
    Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C
     calls second(). "firstsecondthird" is the correct output.


    Note:

    We do not know how the threads will be scheduled in the operating system, even though the numbers
    in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
*/


    /**
     * 按顺序打印123
     * 思路：通过信号量实现，first先执行然后通过释放second，让second函数获取许可，再释放third以让third获取许可。
     */
    static class Foo {

        private volatile int flag = 0;
        private Semaphore first = new Semaphore(1);
        private Semaphore second = new Semaphore(0);
        private Semaphore third = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            first.acquire();
            printFirst.run();
            second.release();

        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            second.acquire();
            printSecond.run();
            third.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            third.acquire();
            printThird.run();
        }
    }


//    /**
//     * 按顺序打印123
//     * 思路：定义变量flag，加上volatile修饰，保证多线程每次读取时获取的是最后修改的值，
//     * 当flag不为1时，阻塞second，不为2时阻塞third,最后执行first或者second后，需要再唤醒其他处于阻塞的所有线程。
//     */
//    static class Foo {
//
//        private volatile int flag = 0;
//
//        public Foo() {
//
//        }
//
//        public void first(Runnable printFirst) throws InterruptedException {
//            // printFirst.run() outputs "first". Do not change or remove this line.
//            synchronized (this) {
//                printFirst.run();
//                flag = 1;
//                this.notifyAll();
//            }
//
//        }
//
//        public void second(Runnable printSecond) throws InterruptedException {
//            // printSecond.run() outputs "second". Do not change or remove this line.
//            synchronized (this) {
//                while (flag != 1) {
//                    this.wait();
//                }
//                printSecond.run();
//                flag = 2;
//                this.notifyAll();
//            }
//        }
//
//        public void third(Runnable printThird) throws InterruptedException {
//            // printThird.run() outputs "third". Do not change or remove this line.
//            synchronized (this) {
//                while (flag != 2) {
//                    this.wait();
//                }
//                printThird.run();
//            }
//        }
//    }

}
