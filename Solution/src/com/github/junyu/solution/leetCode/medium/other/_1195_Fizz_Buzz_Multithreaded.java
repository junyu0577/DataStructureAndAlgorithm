package com.github.junyu.solution.leetCode.medium.other;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class _1195_Fizz_Buzz_Multithreaded {

    /*Write a program that outputs the string representation of numbers from 1 to n, however:

    If the number is divisible by 3, output "fizz".
    If the number is divisible by 5, output "buzz".
    If the number is divisible by both 3 and 5, output "fizzbuzz".
    For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

    Suppose you are given the following code:

    class FizzBuzz {
        public FizzBuzz(int n) { ... }               // constructor
        public void fizz(printFizz) { ... }          // only output "fizz"
        public void buzz(printBuzz) { ... }          // only output "buzz"
        public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
        public void number(printNumber) { ... }      // only output the numbers
    }
    Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be
    passed to four different threads:

    Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
    Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
    Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
    Thread D will call number() which should only output the numbers.*/

    /**
     * 交替打印字符串
     * 思路：
     */
    class FizzBuzz {
        private int n;
        private int index = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            synchronized (this) {
                while (index <= n) {
                    if (index % 3 != 0 || index % 5 == 0)
                        this.wait();
                    else {
                        printFizz.run();
                        index++;
                        notifyAll();
                    }
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            synchronized (this) {
                while (index <= n) {
                    if (index % 5 != 0 || index % 3 == 0)
                        this.wait();
                    else {
                        printBuzz.run();
                        index++;
                        notifyAll();
                    }

                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            synchronized (this) {
                while (index <= n) {
                    if (index % 3 != 0 || index % 5 != 0) {
                        this.wait();
                    } else {
                        printFizzBuzz.run();
                        index++;
                        notifyAll();
                    }
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            synchronized (this) {
                while (index <= n) {
                    if (index % 3 == 0 || index % 5 == 0)
                        this.wait();
                    else {
                        printNumber.accept(index);
                        index++;
                        notifyAll();
                    }
                }
            }
        }
    }


//    /**
//     * 交替打印字符串
//     * 思路：使用信号量，所以函数都需要从1循环至n，同时在fizz中判断如果能被3整除时，去申请许可，其他情况都继续循环。
//     * buzz和其他fizzbuzz同理一个判断被5整除，一个判断同时被3和5整除。
//     * 在number中，只有同时无法被3和5整除时，才申请许可，执行完毕，释放number，如果被3整除，则释放fizz，被5整，释放buzz，
//     * 也就是说通过number函数去控制该释放谁。
//     */
//    class FizzBuzz {
//        private int n;
//        private Semaphore fizz = new Semaphore(0);
//        private Semaphore buzz = new Semaphore(0);
//        private Semaphore fizzBuzz = new Semaphore(0);
//        private Semaphore number = new Semaphore(1);
//
//        public FizzBuzz(int n) {
//            this.n = n;
//        }
//
//        // printFizz.run() outputs "fizz".
//        public void fizz(Runnable printFizz) throws InterruptedException {
//            for (int i = 1; i <= n; i++) {
//                if (i % 3 == 0 && i % 5 != 0) {
//                    fizz.acquire();
//                    printFizz.run();
//                    number.release();
//                }
//            }
//        }
//
//        // printBuzz.run() outputs "buzz".
//        public void buzz(Runnable printBuzz) throws InterruptedException {
//            for (int i = 1; i <= n; i++) {
//                if (i % 3 != 0 && i % 5 == 0) {
//                    buzz.acquire();
//                    printBuzz.run();
//                    number.release();
//                }
//            }
//        }
//
//        // printFizzBuzz.run() outputs "fizzbuzz".
//        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//            for (int i = 1; i <= n; i++) {
//                if (i % 3 == 0 && i % 5 == 0) {
//                    fizzBuzz.acquire();
//                    printFizzBuzz.run();
//                    number.release();
//                }
//            }
//        }
//
//        // printNumber.accept(x) outputs "x", where x is an integer.
//        public void number(IntConsumer printNumber) throws InterruptedException {
//            for (int i = 1; i <= n; i++) {
//                int by3 = i % 3;
//                int by5 = i % 5;
//                if (by3 != 0 && by5 != 0) {
//                    number.acquire();
//                    printNumber.accept(i);
//                    number.release();
//                } else if (by3 == 0 && by5 == 0) {
//                    fizzBuzz.release();
//                } else if (by3 == 0) {
//                    fizz.release();
//                } else
//                    buzz.release();
//            }
//        }
//    }


}
