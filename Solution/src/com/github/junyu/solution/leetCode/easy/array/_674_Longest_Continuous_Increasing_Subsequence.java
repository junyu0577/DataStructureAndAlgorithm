package com.github.junyu.solution.leetCode.easy.array;

public class _674_Longest_Continuous_Increasing_Subsequence {

  /*  Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

    Example 1:
    Input: [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
    Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
    Example 2:
    Input: [2,2,2,2,2]
    Output: 1
    Explanation: The longest continuous increasing subsequence is [2], its length is 1.
    Note: Length of the array will not exceed 10,000.*/

    /**
     * 求最长连续递增序列
     * 定义一个count保存当前最长的纪录，max保存整个数组中递增的最大的长度
     * 默认1个数就是1，第二个元素如果是递增的，那么count++。如果不是小于等于上一个元素，那么就比较
     * count和max的值并取最大的，然后count重置为1
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int count = 1;
        int max = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                count++;
            } else {
                max = Math.max(max,count);
                count = 1;
            }
        }

        return Math.max(max,count);
    }

    public static void main(String [] args) {
//        int arr [] = {1,3,5,4,7};
        int arr [] = {2,2,2,2,2};
        _674_Longest_Continuous_Increasing_Subsequence longest_continuous_increasing_subsequence = new _674_Longest_Continuous_Increasing_Subsequence();
        System.out.println(longest_continuous_increasing_subsequence.findLengthOfLCIS(arr));
    }

}
