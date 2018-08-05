package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.linear.*;

/**
 * 用于测试线性数据结构
 *
 * @author ShaoJunyu
 * @since 2018/8/1 08:12
 */
public class LinearTest {

    public static void main(String[] args) {


//        testArray();
//
//        testStack();


//        testQueue();

        testLoopQueue();
    }

    private static void testLoopQueue() {
        LoopQueue lq = new LoopQueue();
        for (int i = 0; i < 10; i++) {
            lq.enQueue(i);
            System.out.println(lq);

            if ((i + 1) % 3 == 0) {
                lq.deQueue();
                System.out.println(lq);
            }
        }

    }

    private static void testQueue() {

        QueueArray queueArray = new QueueArray();
        for (int i = 0; i < 10; i++) {
            queueArray.enQueue(i);
            System.out.println(queueArray);
        }
        for (int i = 0; i < 3; i++) {
            queueArray.deQueue();
            System.out.println(queueArray);
        }

    }

    private static void testStack() {
        StackArray<Integer> stack = new StackArray<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.top());
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

    }

    private static void testArray() {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addFirst(i);
            System.out.println(arr);
        }

        for (int i = 0; i < 8; i++) {
            arr.remove(0);
            System.out.println(arr);
        }

        arr.removeFirst();
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
    }
}
