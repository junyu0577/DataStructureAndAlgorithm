package com.github.junyu.solution.leetCode.hard.hashTable;


import java.util.*;

public class _895_Maximum_Frequency_Stack {

   /* Implement FreqStack, a class which simulates the operation of a stack-like data structure.

    FreqStack has two functions:

    push(int x), which pushes an integer x onto the stack.
    pop(), which removes and returns the most frequent element in the stack.
    If there is a tie for most frequent element, the element closest to the top of the stack
    is removed and returned.


            Example 1:

    Input:
            ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
            [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
    Output: [null,null,null,null,null,null,null,5,7,5,4]
    Explanation:
    After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

    pop() -> returns 5, as 5 is the most frequent.
    The stack becomes [5,7,5,7,4].

    pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
    The stack becomes [5,7,5,4].

    pop() -> returns 5.
    The stack becomes [5,7,4].

    pop() -> returns 4.
    The stack becomes [5,7].


    Note:

    Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
    It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
    The total number of FreqStack.push calls will not exceed 10000 in a single test case.
    The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
    The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.*/


    private HashMap<Integer, Integer> freq;
    private HashMap<Integer, Stack<Integer>> map;
    private int maxFreq = 0;

    /**
     * 设计一个每次pop出现频率最高的栈
     * freq里统计数字对应的频率，map里对应不同频率的所有元素的，元素存进栈中，以保证在出现相同频率时，
     * 优先pop出接近栈顶的元素。
     * 另外需要维护一个变量，统计现有的最大的频率数。每次pop一个元素后，如果最大频率对应的栈空了，那么就需要对
     * 最大频率变量进行-1操作。
     */
    public _895_Maximum_Frequency_Stack() {

        freq = new HashMap<>();
        map = new HashMap<>();

    }

    public void push(int x) {
        int curFreq = freq.getOrDefault(x, 0) + 1;

        freq.put(x,curFreq);

        maxFreq = Math.max(maxFreq, curFreq);

        if (!map.containsKey(curFreq)) {
            map.put(curFreq, new Stack<>());
        }

        map.get(curFreq).push(x);

    }

    public int pop() {
        int res = map.get(maxFreq).pop();

        freq.put(res, maxFreq - 1);

        if (map.get(maxFreq).size() == 0) {
            maxFreq--;
        }

        return res;
    }

    public static void main(String[] args) {
        _895_Maximum_Frequency_Stack maximum_frequency_stack = new _895_Maximum_Frequency_Stack();
        maximum_frequency_stack.push(5);
        maximum_frequency_stack.push(7);
        maximum_frequency_stack.push(5);
        maximum_frequency_stack.push(7);
        maximum_frequency_stack.push(4);
        maximum_frequency_stack.push(5);

        System.out.println(maximum_frequency_stack.pop());
        System.out.println(maximum_frequency_stack.pop());
        System.out.println(maximum_frequency_stack.pop());
        System.out.println(maximum_frequency_stack.pop());
        System.out.println(maximum_frequency_stack.pop());
        System.out.println(maximum_frequency_stack.pop());

    }

}
