package com.github.junyu.solution.leetCode.easy.others;


import java.util.Stack;

public class _682_Baseball_Game {

   /* You're now a baseball game point recorder.

    Given a list of strings, each string can be one of the 4 following types:

    Integer (one round's score): Directly represents the number of points you get in this round.
            "+" (one round's score): Represents that the points you get in this round are the sum
            of the last two valid round's points.
            "D" (one round's score): Represents that the points you get in this round are the
            doubled data of the last valid round's points.
            "C" (an operation, which isn't a round's score): Represents the last valid round's
    points you get were invalid and should be removed.
    Each round's operation is permanent and could have an impact on the round before and the round after.

    You need to return the sum of the points you could get in all the rounds.

    Example 1:
    Input: ["5","2","C","D","+"]
    Output: 30
    Explanation:
    Round 1: You could get 5 points. The sum is: 5.
    Round 2: You could get 2 points. The sum is: 7.
    Operation 1: The round 2's data was invalid. The sum is: 5.
    Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
            Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
            Example 2:
            Input: ["5","-2","4","C","D","9","+","+"]
            Output: 27
                  Explanation:
                  Round 1: You could get 5 points. The sum is: 5.
                  Round 2: You could get -2 points. The sum is: 3.
                  Round 3: You could get 4 points. The sum is: 7.
                  Operation 1: The round 3's data is invalid. The sum is: 3.
                  Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
                  Round 5: You could get 9 points. The sum is: 8.
                  Round 6: You could get -4 + 9 = 5 points. The sum is 13.
                  Round 7: You could get 9 + 5 = 14 points. The sum is 27.
                  Note:
                  The size of the input list will be between 1 and 1000.
                  Every integer represented in the list will be between -30000 and 30000.

*/

    /**
     * 棒球比赛得分总和
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     * 将每轮的得分压入栈中，遇到C就直接从栈中移除一轮得分，遇D就将peek下栈顶的元素,*2后加入新一轮的得分。遇+就将栈中的前2个
     * 元素求和再加入得分。
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    int last1 = stack.pop();
                    int last2 = stack.pop();
                    stack.push(last2);
                    stack.push(last1);

                    int total = last1 + last2;

                    stack.push(total);

                    sum += total;

                    break;
                case "D":
                    int last = stack.peek();
                    int res = last << 1;
                    stack.push(res);

                    sum += res;

                    break;
                case "C":
                    sum -= stack.pop();
                    break;
                default:
                    sum += Integer.valueOf(ops[i]);
                    stack.push(Integer.valueOf(ops[i]));
                    break;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(new _682_Baseball_Game().calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(new _682_Baseball_Game().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

}
