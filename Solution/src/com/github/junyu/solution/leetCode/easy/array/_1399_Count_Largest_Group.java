package com.github.junyu.solution.leetCode.easy.array;

public class _1399_Count_Largest_Group {

    /*Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.

    Return how many groups have the largest size.

    Example 1:

    Input: n = 13
    Output: 4
    Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
            [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
    Example 2:

    Input: n = 2
    Output: 2
    Explanation: There are 2 groups [1], [2] of size 1.
    Example 3:

    Input: n = 15
    Output: 6
    Example 4:

    Input: n = 24
    Output: 5


    Constraints:

            1 <= n <= 10^4*/

    /**
     * 求数字1-n中各位数和，统计相同和最多的组数量
     * 思路：n的范围在1-10000，所以最大的各位数和为4*9=36，那么开辟一个长为37的数组，然后统计1-n中各位数并保存在数组对应的索引位置。
     * 然后遍历数组，找出最大和的组并统计这些组的数量
     *
     * @param n
     * @return
     */
    public int countLargestGroup(int n) {
        int max = 0;
        int ans = 1;
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int val = i;
            int sum = 0;
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }
            count[sum]++;
        }
        for (int i : count) {
            if (i > max) {
                max = i;
                ans = 1;
            } else if (i == max)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1399_Count_Largest_Group test = new _1399_Count_Largest_Group();
        System.out.println(test.countLargestGroup(13));
        System.out.println(test.countLargestGroup(2));
        System.out.println(test.countLargestGroup(15));
        System.out.println(test.countLargestGroup(24));
    }
}
