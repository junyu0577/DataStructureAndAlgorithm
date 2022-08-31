package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _2389_Longest_Subsequence_With_Limited_Sum {

    /*
    You are given an integer array nums of length n, and an integer array queries of length m.

    Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].

    A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



    Example 1:

    Input: nums = [4,5,2,1], queries = [3,10,21]
    Output: [2,3,4]
    Explanation: We answer the queries as follows:
            - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
            - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
            - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
    Example 2:

    Input: nums = [2,3,4,5], queries = [1]
    Output: [0]
    Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.


    Constraints:

    n == nums.length
    m == queries.length
    1 <= n, m <= 1000
    1 <= nums[i], queries[i] <= 106

    */

    /**
     * 和有限的最长子序列。
     * 先对nums进行排序然后算[1至len-1]的前缀和，并赋值在当前位置。
     * 最后使用二分查询快速匹配出子序列和(nums中的元素)小于等于当前queries元素的目标
     *
     * Runtime: 5 ms, faster than 98.79% of Java online submissions for Longest Subsequence With Limited Sum.
     * Memory Usage: 42.9 MB, less than 91.38% of Java online submissions for Longest Subsequence With Limited Sum.
     *
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            nums[i] = nums[i]+nums[i-1];
        }
        for (int i=0;i<queries.length;i++){
            int mid;
            int left = 0;
            int right = nums.length;
            while (left<right){
              mid = (right-left)/2+left;
              if (nums[mid]>queries[i]){
                  right = mid;
              } else {
                  left = mid+1;
              }
            }
            queries[i] = left;
        }
        return queries;
    }
    
    public static void main(String [] args) {
        _2389_Longest_Subsequence_With_Limited_Sum test = new _2389_Longest_Subsequence_With_Limited_Sum();
        System.out.println(Arrays.toString(test.answerQueries(new int[]{4,5,2,1},new int[]{3,10,21})));
        System.out.println(Arrays.toString(test.answerQueries(new int[]{2,3,4,5},new int[]{1})));
    }
}
