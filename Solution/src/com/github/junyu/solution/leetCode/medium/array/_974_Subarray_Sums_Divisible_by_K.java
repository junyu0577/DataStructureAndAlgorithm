package com.github.junyu.solution.leetCode.medium.array;

import java.util.HashMap;

public class _974_Subarray_Sums_Divisible_by_K {

    /*Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible
    by K.

    Example 1:

    Input: A = [4,5,0,-2,-3,1], K = 5
    Output: 7
    Explanation: There are 7 subarrays with a sum divisible by K = 5:
            [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]


    Note:

            1 <= A.length <= 30000
            -10000 <= A[i] <= 10000
            2 <= K <= 10000*/

    /**
     * 和可被 K 整除的子数组
     * 思路：如果两个数的差能被K整除，就说明这两个数 mod K得到的结果相同，
     * 求前缀和，然后再进行取模，统计有多少对mod相同的数的组合即可。
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//默认添加一个0，不然当mod有0时会出现统计偏差
        for (int i : A) {
            int mod = i % K;
            mod = mod < 0 ? mod + K : mod;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        int sum = 0;
        for (int i : map.values()) {
            sum += i * (i - 1) / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        _974_Subarray_Sums_Divisible_by_K test = new _974_Subarray_Sums_Divisible_by_K();
        System.out.println(test.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(test.subarraysDivByK(new int[]{-1, 2, 9}, 2));
        System.out.println(test.subarraysDivByK(new int[]{-1, -9, -4, 0}, 9));
    }
}
