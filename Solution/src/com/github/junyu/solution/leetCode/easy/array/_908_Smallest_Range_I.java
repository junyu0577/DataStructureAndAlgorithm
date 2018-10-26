package com.github.junyu.solution.leetCode.easy.array;

public class _908_Smallest_Range_I {

   /* Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].

    After this process, we have some array B.

    Return the smallest possible difference between the maximum value of B and the minimum value of B.


    Example 1:

    Input: A = [1], K = 0
    Output: 0
    Explanation: B = [1]
    Example 2:

    Input: A = [0,10], K = 2
    Output: 6
    Explanation: B = [2,8]
    Example 3:

    Input: A = [1,3,6], K = 3
    Output: 0
    Explanation: B = [3,3,3] or B = [4,4,4]


    Note:

    1 <= A.length <= 10000
    0 <= A[i] <= 10000
    0 <= K <= 10000

    */

    /**
     * 将A中的元素加上x（-k<=x<=k）,生成新的数组B，使得B中的最大的元素和最小的元素的差值尽可能的小。
     * 思路：我们可以通过让生成的B数组的值尽量向中间值靠拢，如果所有的数都相等，那么最后的差值就为0。所以这题转换下
     * 思路就是获得A中的最大值和最小值，如果他们的差值大于2倍的k，那么将差值减去2k即是答案（(max-k) - (min+k)）。
     * 如果小于等于2k，那么说明数组B的差值肯定可以为0。
     *
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];

            if (A[i] < min)
                min = A[i];
        }

        if (max - min > 2 * K) {
            return (max - min) - 2 * K;
        }
        return 0;
    }

    public static void main(String[] args) {
        _908_Smallest_Range_I smallest_range_i = new _908_Smallest_Range_I();
        System.out.println(smallest_range_i.smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(smallest_range_i.smallestRangeI(new int[]{1, 3, 6}, 3));
    }

}
