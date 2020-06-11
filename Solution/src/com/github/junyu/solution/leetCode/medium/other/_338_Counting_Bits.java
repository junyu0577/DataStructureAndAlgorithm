package com.github.junyu.solution.leetCode.medium.other;

import java.util.Arrays;

public class _338_Counting_Bits {

   /* Given a non negative integer number num. For every numbers i in the
        range 0 ≤ i ≤ num calculate the number of 1
            's in their binary representation and return them as an array.

    Example 1:

    Input: 2
    Output: [0,1,1]
    Example 2:

    Input: 5
    Output: [0,1,1,2,1,2]
    Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)).
     But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function
    like __builtin_popcount in c++ or in any other language.
*/

    /**
     * 统计0-num分别的二进制分别包含多少个1
     * 思路：按顺序统计1的数量
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = countOne(i);
        }
        return ans;
    }

    private int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }


    public static void main(String[] args) {
        _338_Counting_Bits test = new _338_Counting_Bits();
        System.out.println(Arrays.toString(test.countBits(2)));
        System.out.println(Arrays.toString(test.countBits(5)));
    }
}
