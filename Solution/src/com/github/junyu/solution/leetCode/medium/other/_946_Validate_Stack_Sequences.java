package com.github.junyu.solution.leetCode.medium.other;

import java.util.Stack;

public class _946_Validate_Stack_Sequences {

    /*Given two sequences pushed and popped with distinct values, return true if
    and only if this could have been the result of a sequence of push and pop
    operations on an initially empty stack.

    Example 1:

    Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    Output: true
    Explanation: We might do the following sequence:
    push(1), push(2), push(3), push(4), pop() -> 4,
    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
    Example 2:

    Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    Output: false
    Explanation: 1 cannot be popped before 2.


    Note:

            0 <= pushed.length == popped.length <= 1000
            0 <= pushed[i], popped[i] < 1000
    pushed is a permutation of popped.
    pushed and popped have distinct values.
*/

    /**
     * 验证两个数组是否符合栈的入栈出栈结果
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0)
            return true;
        int p = 0;
        int len = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && p < len && stack.peek() == popped[p]) {
                stack.pop();
                p++;
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        _946_Validate_Stack_Sequences validate_stack_sequences = new _946_Validate_Stack_Sequences();
        System.out.println(validate_stack_sequences.validateStackSequences(pushed, popped));
    }
}
