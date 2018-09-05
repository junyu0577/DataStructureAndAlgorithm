package com.github.junyu.solution.leetCode.easy.others;

public class _868_Binary_Gap {

    /*Given a positive integer N, find and return the longest distance between two consecutive
        1's in the binary representation of N.

    If there aren't two consecutive 1's, return 0.

    Example 1:

    Input: 22
    Output: 2
    Explanation:
            22 in binary is 0b10110.
    In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
    The first consecutive pair of 1's have distance 2.
    The second consecutive pair of 1's have distance 1.
    The answer is the largest of these two distances, which is 2.
    Example 2:

    Input: 5
    Output: 2
    Explanation:
            5 in binary is 0b101.
    Example 3:

    Input: 6
    Output: 1
    Explanation:
            6 in binary is 0b110.
    Example 4:

    Input: 8
    Output: 0
    Explanation:
            8 in binary is 0b1000.
    There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.


    Note:

            1 <= N <= 10^9*/

    /**
     * 二进制中两个1的最大距离
     * 定义max存放最大的距离，start用于统计当前的距离。
     * 从最低位开始判断，如果是1，那么判断是否已经在之前出现过1，如果出现过那么，start肯定不为0,start就是两个1的距离。
     * 如果start大于max，那么更新max的值，然后将start归零。然后以当前的1为出发点，比较后面的距离。
     *
     * @param N
     * @return
     */
    public int binaryGap(int N) {
        int max = 0;
        int start = 0;

        while (N != 0) {

            if ((N & 1) == 1) {
                if (start > 0) {
                    max = Math.max(max, start);
                    start = 0;
                }
                start++;
            } else if (start > 0) {
                start++;
            }

            N = N >> 1;
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(new _868_Binary_Gap().binaryGap(22));
        System.out.println(new _868_Binary_Gap().binaryGap(5));
        System.out.println(new _868_Binary_Gap().binaryGap(6));
        System.out.println(new _868_Binary_Gap().binaryGap(8));
    }
}
