package com.github.junyu.solution.leetCode.medium.other;


import java.util.Stack;

public class _150_Evaluate_Reverse_Polish_Notation {

   /* Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

            Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate
    to a result and there won't be any divide by zero operation.
    Example 1:

    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
    Example 2:

    Input: ["4", "13", "5", "/", "+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6
    Example 3:

    Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    Output: 22
    Explanation:
            ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
            = ((10 * (6 / (12 * -11))) + 17) + 5
            = ((10 * (6 / -132)) + 17) + 5
            = ((10 * 0) + 17) + 5
            = (0 + 17) + 5
            = 17 + 5
            = 22*/

    /**
     * 逆波兰表示式求解
     * 使用栈求解，遇到数字就将数字压入栈，遇到符号就从栈中取出两个数进行计算，计算结果再次压入栈，如果循环遍历完整个数组，最后
     * 栈中的元素就是结果
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        int num1;
        int num2;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    nums.push(nums.pop() + nums.pop());
                    break;
                case "-":
                    num2 = nums.pop();
                    num1 = nums.pop();
                    nums.push(num1 - num2);
                    break;
                case "*":
                    nums.push(nums.pop() * nums.pop());
                    break;
                case "/":
                    num2 = nums.pop();
                    num1 = nums.pop();
                    nums.push(num1 / num2);
                    break;
                default:
                    nums.push(Integer.valueOf(tokens[i]));
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        System.out.println(new _150_Evaluate_Reverse_Polish_Notation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new _150_Evaluate_Reverse_Polish_Notation().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(new _150_Evaluate_Reverse_Polish_Notation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}
