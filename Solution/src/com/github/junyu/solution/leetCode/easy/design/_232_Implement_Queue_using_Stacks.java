package com.github.junyu.solution.leetCode.easy.design;


import java.util.Stack;

public class _232_Implement_Queue_using_Stacks {


/*    Implement the following operations of a queue using stacks.

            push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.
    Example:

    MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
    Notes:

    You must use only standard operations of a stack -- which means only push to top,
    peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a
    stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations
            will be called on an empty queue).*/

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * 用两个stack实现一个队列
     * 队列是先进先出原则，而栈是先进后出，那么定义两个栈，每次add的时候，都往stack1中去添加，
     * pop或者peek的时候，则先查看stack2中是否有元素，如果有就直接出栈或者查看，没有的话就先去stack1中查看是否
     * 有元素，如果有先将stack1中的元素都push到stack2中，这样第一个进入的元素就位于栈顶。
     */
    public _232_Implement_Queue_using_Stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int x = stack1.pop();
                stack2.push(x);
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int x = stack1.pop();
                stack2.push(x);
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.size() + stack2.size() == 0;
    }

    public static void main(String [] args) {
        _232_Implement_Queue_using_Stacks q = new _232_Implement_Queue_using_Stacks();
        q.push(1);
        q.push(2);
        System.out.println(q.pop());
        q.push(3);
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
