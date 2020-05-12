package com.github.junyu.solution.leetCode.medium.math;

import java.util.Arrays;

public class _1362_Closest_Divisors {

    /*Given an integer num, find the closest two integers in absolute difference whose
    product equals num + 1 or num + 2.

    Return the two integers in any order.

    Example 1:

    Input: num = 8
    Output: [3,3]
    Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest divisors are 2 & 5,
    hence 3 & 3 is chosen.
    Example 2:

    Input: num = 123
    Output: [5,25]
    Example 3:

    Input: num = 999
    Output: [40,25]

    Constraints:

    1 <= num <= 10^9*/

    /**
     * 获取num+1或者num+2后除数与被除数最近接的组合
     * 思路：通过开根先获取除数，然后通过降低除数确定当前num的除数和被除数。
     * 最后通过比较num+1和num+2的除数和被除数的差值，返回差值最小的组合。
     * @param num
     * @return
     */
    public int[] closestDivisors(int num) {

        int divisorArr[] = getDivisors(num + 1);
        int divisorArr2[] = getDivisors(num + 2);

        int result = Math.abs(divisorArr[0] - divisorArr[1]);
        int result2 = Math.abs(divisorArr2[0] - divisorArr2[1]);

        return result < result2 ? divisorArr : divisorArr2;
    }

    private int[] getDivisors(int num) {
        int root = (int) Math.sqrt(num);
        while (root > 0) {
            if (num % root == 0)
                return new int[]{root, (num / root)};
            root--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        _1362_Closest_Divisors test = new _1362_Closest_Divisors();
        System.out.println(Arrays.toString(test.closestDivisors(8)));
        System.out.println(Arrays.toString(test.closestDivisors(123)));
        System.out.println(Arrays.toString(test.closestDivisors(999)));
    }
}
