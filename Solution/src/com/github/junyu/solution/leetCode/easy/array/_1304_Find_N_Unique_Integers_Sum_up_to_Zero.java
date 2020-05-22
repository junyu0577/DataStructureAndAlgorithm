package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1304_Find_N_Unique_Integers_Sum_up_to_Zero {



    /*Given an integer n, return any array containing n unique integers such that
    they add up to 0.

    Example 1:

    Input: n = 5
    Output: [-7,-1,1,3,4]
    Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
    Example 2:

    Input: n = 3
    Output: [-1,0,1]
    Example 3:

    Input: n = 1
    Output: [0]


    Constraints:

            1 <= n <= 1000*/

    /**
     * 构建一个长度为n，所以元素和为0的数组
     * 思路：按顺序从1开始往数组中添加元素，并且统计当前的和，再最后一个位置插入这个和的负数。
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i + 1;
            sum += i + 1;
        }
        ans[n-1] = -sum;
        return ans;
    }

    private static boolean checkAns(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for (int num : arr)
            sum += num;

        return sum == 0;
    }

    public static void main(String[] args) {
        _1304_Find_N_Unique_Integers_Sum_up_to_Zero test = new _1304_Find_N_Unique_Integers_Sum_up_to_Zero();
        System.out.println(test.checkAns(test.sumZero(5)));
        System.out.println(test.checkAns(test.sumZero(3)));
        System.out.println(test.checkAns(test.sumZero(1)));
    }
}
