package com.github.junyu.solution.leetCode.medium.design;

import java.util.Stack;

public class _1381_Design_a_Stack_With_Increment_Operation {

/*    Design a stack which supports the following operations.

    Implement the CustomStack class:

    CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack
     or do nothing if the stack reached the maxSize.
    void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
    int pop() Pops and returns the top of stack or -1 if the stack is empty.
    void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements
    in the stack, just increment all the elements in the stack.

    Example 1:

    Input
    ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
            [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
        Output
    [null,null,null,2,null,null,null,null,null,103,202,201,-1]
        Explanation
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
    customStack.push(1);                          // stack becomes [1]
    customStack.push(2);                          // stack becomes [1, 2]
    customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
    customStack.push(2);                          // stack becomes [1, 2]
    customStack.push(3);                          // stack becomes [1, 2, 3]
    customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
    customStack.increment(5, 100);                // stack becomes [101, 102, 103]
    customStack.increment(2, 100);                // stack becomes [201, 202, 103]
    customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201,
    202]
    customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
    customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
    customStack.pop();                            // return -1 --> Stack is empty return -1.


    Constraints:

            1 <= maxSize <= 1000
            1 <= x <= 1000
            1 <= k <= 1000
            0 <= val <= 100
    At most 1000 calls will be made to each method of increment, push and pop each separately.*/

    /**
     * 实现自定义栈类 CustomStack ：
     * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize
     * 之后则不支持 push 操作。
     * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
     * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
     * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val
     */
    public static class CustomStack {

        int[] data;
        int index = -1;
        int size;

        public CustomStack(int maxSize) {
            data = new int[maxSize];
            this.size = maxSize;
        }

        public void push(int x) {
            if (index + 1 >= size)
                return;

            data[++index] = x;
        }

        public int pop() {
            if (index==-1)
                return -1;

            int value = data[index];
            index--;
            return value;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < data.length; i++) {
                if (i + 1 <= k && data[i] != 0)
                    data[i] = data[i] + val;
            }
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
//        ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
        customStack.push(1);
        customStack.pop();
        customStack.increment(5, 100);
        customStack.pop();

    }
}
