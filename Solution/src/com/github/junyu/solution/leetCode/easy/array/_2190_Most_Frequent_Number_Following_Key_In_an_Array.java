package com.github.junyu.solution.leetCode.easy.array;


public class _2190_Most_Frequent_Number_Following_Key_In_an_Array {

    /*
    You are given a 0-indexed integer array nums. You are also given an integer key, which
    is present in nums.

    For every unique integer target in nums, count the number of times target immediately
    follows an occurrence of key in nums. In other words, count the number of indices i such that:

            0 <= i <= n - 2,
    nums[i] == key and,
    nums[i + 1] == target.
    Return the target with the maximum count. The test cases will be generated such that
    the target with maximum count is unique.


    Example 1:

    Input: nums = [1,100,200,1,100], key = 1
    Output: 100
    Explanation: For target = 100, there are 2 occurrences at indices 1 and 4 which follow an
    occurrence of key.
    No other integers follow an occurrence of key, so we return 100.
    Example 2:

    Input: nums = [2,2,2,2,3], key = 2
    Output: 2
    Explanation: For target = 2, there are 3 occurrences at indices 1, 2, and 3 which follow
    an occurrence of key.
    For target = 3, there is only one occurrence at index 4 which follows an occurrence of key.
    target = 2 has the maximum number of occurrences following an occurrence of key, so we return 2.


    Constraints:

            2 <= nums.length <= 1000
            1 <= nums[i] <= 1000
    The test cases will be generated such that the answer is unique.
    */

    /**
     * 数组中紧跟 key 之后出现最频繁的数字
     *
     * 遍历数组先统计出跟随在key元素后一位的元素的个数，然后统计这些元素谁出现的最多。
     *
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Most Frequent Number Following Key In an Array.
     * Memory Usage: 46 MB, less than 42.86% of Java online submissions for Most Frequent Number Following Key In an Array.
     *
     * @param nums
     * @param key
     * @return
     */
    public int mostFrequent(int[] nums, int key) {
        int [] count = new int[1001];
        for (int i=1;i<nums.length;i++){
            if (nums[i-1] == key){
                count[nums[i]]++;
            }
        }

        int ans = 0;
        int curCount = 0;

        for (int i=0;i<nums.length;i++){
            if (count[nums[i]]>curCount){
                curCount = count[nums[i]];
                ans = nums[i];
            }
        }

        return ans;
    }

    public static void main(String [] args) {
        _2190_Most_Frequent_Number_Following_Key_In_an_Array test = new _2190_Most_Frequent_Number_Following_Key_In_an_Array();
        System.out.println(test.mostFrequent(new int[]{1,100,200,1,100},1));
        System.out.println(test.mostFrequent(new int[]{2,2,2,2,3},2));
        System.out.println(test.mostFrequent(new int[]{2,1000,2,1000,2,3},2));
        System.out.println(test.mostFrequent(new int[]{1,555,2,555,3,555,2},2));
        System.out.println(test.mostFrequent(new int[]{11,22,11,33,11,33},11));
    }
}
