package com.github.junyu.solution.leetCode.easy.design;


/**
 * @author ShaoJunyu
 * @since 2018/8/1 09:50
 */
public class _155_Min_Stack {

 /*   Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

            push(x) -- Push element x onto stack.
            pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
            Example:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
                minStack.pop();
    minStack.top();      --> Returns 0.
            minStack.getMin();   --> Returns -2.*/

    public class ListNode {

        public int val;
        public int min;
        public ListNode next;

        private ListNode(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private ListNode node;

    /**
     * 用链表来使用一个栈，多加入一个最小值的属性，每次插入前和top的min去比较，进而更新min的值,达成获取最小值只用O（1）的时间复杂度
     */
    public _155_Min_Stack() {
    }

    public void push(int x) {
        if (node == null) {
            node = new ListNode(x, x);
        } else {
            ListNode newNode = new ListNode(x, Math.min(x, node.min));
            newNode.next = node;
            node = newNode;
        }
    }

    public void pop() {
        if (node == null)
            return;

        node = node.next;
    }

    public int top() {
        if (node == null)
            return -1;
        else
            return node.val;
    }

    public int getMin() {
        if (node == null)
            return -1;
        else
            return node.min;
    }

    public static void main(String[] args) {
        _155_Min_Stack stack = new _155_Min_Stack();
        System.out.println(stack.getMin());
        stack.push(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

}
