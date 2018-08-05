package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.linear.Array;
import com.github.junyu.solution.data_structure.linear.Stack;
import com.github.junyu.solution.data_structure.linear.StackArray;

/**
 * 用于测试线性数据结构
 *
 * @author ShaoJunyu
 * @since 2018/8/1 08:12
 */
public class LinearTest {

    public static void main(String[] args) {

//        Array<Integer> arr = new Array<>();
//        for (int i = 0; i < 10; i++) {
//            arr.addFirst(i);
//            System.out.println(arr);
//        }

//        for (int i=0;i<8;i++){
//            arr.remove(0);
//            System.out.println(arr);
//        }

//        arr.removeFirst();
//        System.out.println(arr);
//        arr.removeLast();
//        System.out.println(arr);



        StackArray<Integer> stack = new StackArray<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.top());
//        for (int i = 0; i < 10; i++) {
//            System.out.println(stack.pop());
//        }

        System.out.println("min:"+stack.getMin());
    }
}
