package com.github.junyu.solution.leetCode.easy.design;


import java.util.LinkedList;

public class _225_Implement_Stack_using_Queues {


   /* Implement the following operations of a stack using queues.

            push(x) -- Push element x onto stack.
            pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
    Example:

    MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
    Notes:

    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).*/

    private LinkedList<Integer> q1;
    private LinkedList<Integer> q2;

    /**
     * 用队列实现栈，和225的题目类似，这题就用两个队列去实现栈
     * 这里就就linkedList来代替queue，在插入的时候，必须要插在不为空的队列里，如果都为空，那就无所谓了。
     * 在pop的时候，首先判断哪个队列不为空，在不为空的队列中进行元素的出队，并加入到另一个队列中。在循环到最后
     * 一个元素时，记录元素的值。如果是pop操作，那么这个元素无需加入到另一个队列，直接删除即可。如果是top操作，
     * 就需要删除并加入到另一个队列。
     *
     *
     */
    public _225_Implement_Stack_using_Queues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!q1.isEmpty())
            q1.add(x);
        else
            q2.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int res = 0;
        if (!q1.isEmpty()) {
            int len = q1.size();
            for (int i = 0; i < len; i++) {
                if (i == len - 1) {
                    res = q1.removeFirst();
                } else {
                    q2.add(q1.removeFirst());
                }
            }
        } else {
            int len = q2.size();
            for (int i = 0; i < len; i++) {
                if (i == len-1) {
                    res = q2.removeFirst();
                } else {
                    q1.add(q2.removeFirst());
                }
            }
        }
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int res = 0;
        if (!q1.isEmpty()) {
            int len = q1.size();
            for (int i = 0; i < len; i++) {
                if (i == len - 1) {
                    res = q1.peek();
                }
                q2.add(q1.removeFirst());
            }
        } else {
            int len = q2.size();
            for (int i = 0; i < len; i++) {
                if (i == len - 1) {
                    res = q2.peek();
                }
                q1.add(q2.removeFirst());
            }
        }
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        _225_Implement_Stack_using_Queues q = new _225_Implement_Stack_using_Queues();
        System.out.println(q.empty());
        q.push(1);
        q.push(2);
        System.out.println(q.empty());
        System.out.println(q.top());
        System.out.println(q.pop());
        System.out.println(q.empty());
        System.out.println(q.pop());
    }

}
