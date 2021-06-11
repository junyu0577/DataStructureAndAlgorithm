package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashMap;
import java.util.Map;

public class _1742_Maximum_Number_of_Balls_in_a_Box {

/*
    You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit inclusive (i.e.,
    n == highLimit - lowLimit + 1),
    and an infinite number of boxes numbered from 1 to infinity.

    Your job at this factory is to put each ball in the box with a number equal to the sum of digits of
    the ball's number. For example, the ball number 321 will be put in the box number 3 + 2 + 1 = 6 and the ball
    number 10 will be put in the box number 1 + 0 = 1.

    Given two integers lowLimit and highLimit, return the number of balls in the box with the most balls.


    Example 1:

    Input: lowLimit = 1, highLimit = 10
    Output: 2
    Explanation:
    Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
    Ball Count:  2 1 1 1 1 1 1 1 1 0  0  ...
    Box 1 has the most number of balls with 2 balls.
            Example 2:

    Input: lowLimit = 5, highLimit = 15
    Output: 2
    Explanation:
    Box Number:  1 2 3 4 5 6 7 8 9 10 11 ...
    Ball Count:  1 1 1 1 2 2 1 1 1 0  0  ...
    Boxes 5 and 6 have the most number of balls with 2 balls in each.
            Example 3:

    Input: lowLimit = 19, highLimit = 28
    Output: 2
    Explanation:
    Box Number:  1 2 3 4 5 6 7 8 9 10 11 12 ...
    Ball Count:  0 1 1 1 1 1 1 1 1 2  0  0  ...
    Box 10 has the most number of balls with 2 balls.


            Constraints:

            1 <= lowLimit <= highLimit <= 105
    */

    /**
     * 盒子中小球的最大数量
     * 遍历所有小球，计算每个小球的各位数之和后通过map去保存相同和出现的次数。最后遍历map，取出value的最大值。
     *
     * Runtime: 36 ms, faster than 44.10% of Java online submissions for Maximum Number of Balls in a Box.
     * Memory Usage: 38.1 MB, less than 49.78% of Java online submissions for Maximum Number of Balls in a Box.
     *
     * @param lowLimit
     * @param highLimit
     * @return
     */
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > ans) {
                ans = entry.getValue();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _1742_Maximum_Number_of_Balls_in_a_Box test = new _1742_Maximum_Number_of_Balls_in_a_Box();
        System.out.println(test.countBalls(1, 10));
        System.out.println(test.countBalls(5, 15));
        System.out.println(test.countBalls(19, 28));
        System.out.println(test.countBalls(195, 286));
    }
}
