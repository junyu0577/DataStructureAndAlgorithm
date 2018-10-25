package com.github.junyu.solution.leetCode.medium.array;

public class _334_Increasing_Triplet_Subsequence {

   /* Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

    Formally the function should:

    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
    Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

    Example 1:

    Input: [1,2,3,4,5]
    Output: true
    Example 2:

    Input: [5,4,3,2,1]
    Output: false*/


    /**
     * 递增三元子序列
     * 首先定义两个num1，num2变量，赋值为int的最大值。
     * 遍历数组，只有当前的元素小于等于num1，就赋值给他。如果大于num1，那么继续判断是否小于等于num2，如果是就赋值。
     * 当一个数同时大于num1和num2，那么说明数组中肯定存在递增三元子序列，直接返回true。
     * 如果循环结束，则说明没有。
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int num1 = Integer.MAX_VALUE;
        int num2 = num1;

        for (int i : nums) {
            if (i <= num1)
                num1 = i;
            else if (i <= num2)
                num2 = i;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        _334_Increasing_Triplet_Subsequence increasing_triplet_subsequence = new _334_Increasing_Triplet_Subsequence();
        System.out.println(increasing_triplet_subsequence.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasing_triplet_subsequence.increasingTriplet(new int[]{1, 2, 1, 2, 1, 3}));
        System.out.println(increasing_triplet_subsequence.increasingTriplet(new int[]{1,1,1,1,1,1}));
    }


}
