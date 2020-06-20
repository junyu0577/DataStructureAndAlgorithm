package com.github.junyu.solution.leetCode.medium.other;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class _1116_Print_Zero_Even_Odd {

    /*Suppose you are given the following code:

    class ZeroEvenOdd {
        public ZeroEvenOdd(int n) { ... }      // constructor
        public void zero(printNumber) { ... }  // only output 0's
        public void even(printNumber) { ... }  // only output even numbers
        public void odd(printNumber) { ... }   // only output odd numbers
    }
    The same instance of ZeroEvenOdd will be passed to three different threads:

    Thread A will call zero() which should only output 0's.
    Thread B will call even() which should only ouput even numbers.
    Thread C will call odd() which should only output odd numbers.
    Each of the threads is given a printNumber method to output an integer.
    Modify the given program to output the series 010203040506... where the length of the series must be 2n.

    Example 1:

    Input: n = 2
    Output: "0102"
    Explanation: There are three threads being fired asynchronously. One of them calls zero(),
    the other calls even(), and the last one calls odd(). "0102" is the correct output.
    Example 2:

    Input: n = 5
    Output: "0102030405"*/


    /**
     * 打印零与奇偶数
     * 通过两个两个变量去做阻塞，printZero为true是 输出奇数和偶数的函数需要阻塞，如果需要输入奇数printOdd = true，输出偶数的函数需要阻塞。
     * 输出奇数函数同理。每个函数执行完毕，都需要唤醒其他线程.
     */
    class ZeroEvenOdd {
        private int n;
        private volatile boolean printZero = true;
        private volatile boolean printOdd = true;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                for (int i = 1; i <= n; i++) {
                    while (!printZero)
                        this.wait();

                    printZero = false;
                    printNumber.accept(0);
                    this.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                for (int i = 2; i <= n; i += 2) {
                    while (printZero|| printOdd)
                        this.wait();
                    printZero = true;
                    printOdd = true;
                    printNumber.accept(i);
                    this.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                for (int i = 1; i <= n; i += 2) {
                    while (printZero|| !printOdd)
                        this.wait();
                    printZero = true;
                    printOdd = false;
                    printNumber.accept(i);
                    this.notifyAll();
                }
            }
        }
    }


//    /**
//     * 打印零与奇偶数
//     * 通过信号量，许可后打印后判断奇偶数，奇则释放奇数的信号量，偶同理。通过release创建创建许可，acquire消费许可
//     */
//    class ZeroEvenOdd {
//        private int n;
//        private Semaphore zero;
//        private Semaphore odd;
//        private Semaphore even;
//
//        public ZeroEvenOdd(int n) {
//            this.n = n;
//            zero = new Semaphore(1);
//            odd = new Semaphore(0);
//            even = new Semaphore(0);
//        }
//
//        // printNumber.accept(x) outputs "x", where x is an integer.
//        public void zero(IntConsumer printNumber) throws InterruptedException {
//            for (int i = 1; i <= n; i++) {
//                zero.acquire();
//                printNumber.accept(0);
//                if ((i & 1) == 0)
//                    even.release();
//                else
//                    odd.release();
//            }
//        }
//
//        public void even(IntConsumer printNumber) throws InterruptedException {
//            for (int i = 2; i <= n; i += 2) {
//                even.acquire();
//                printNumber.accept(i);
//                zero.release();
//            }
//        }
//
//        public void odd(IntConsumer printNumber) throws InterruptedException {
//            for (int i = 1; i <= n; i += 2) {
//                odd.acquire();
//                printNumber.accept(i);
//                zero.release();
//            }
//        }
//    }

    public static void main(String[] args) {

    }
}
