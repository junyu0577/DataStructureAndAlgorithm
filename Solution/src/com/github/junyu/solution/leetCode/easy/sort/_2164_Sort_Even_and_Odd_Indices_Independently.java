package com.github.junyu.solution.leetCode.easy.sort;

import java.util.*;

public class _2164_Sort_Even_and_Odd_Indices_Independently {


    /*
    You are given a 0-indexed integer array nums. Rearrange the values of nums according to the following rules:

    Sort the values at odd indices of nums in non-increasing order.
    For example, if nums = [4,1,2,3] before this step, it becomes [4,3,2,1] after. The values at odd indices 1 and 3 are sorted in non-increasing order.
    Sort the values at even indices of nums in non-decreasing order.
    For example, if nums = [4,1,2,3] before this step, it becomes [2,1,4,3] after. The values at even indices 0 and 2 are sorted in non-decreasing order.
    Return the array formed after rearranging the values of nums.



    Example 1:

    Input: nums = [4,1,2,3]
    Output: [2,3,4,1]
    Explanation:
    First, we sort the values present at odd indices (1 and 3) in non-increasing order.
    So, nums changes from [4,1,2,3] to [4,3,2,1].
    Next, we sort the values present at even indices (0 and 2) in non-decreasing order.
    So, nums changes from [4,1,2,3] to [2,3,4,1].
    Thus, the array formed after rearranging the values is [2,3,4,1].
    Example 2:

    Input: nums = [2,1]
    Output: [2,1]
    Explanation:
    Since there is exactly one odd index and one even index, no rearrangement of values takes place.
    The resultant array formed is [2,1], which is the same as the initial array.

*/

    /**
     * 奇数位降序，偶数位升序
     * 交换排序 遍历过程中判断当前索引是奇数还是偶数，再按要求进行排序
     *
     * Runtime: 4 ms, faster than 81.01% of Java online submissions for Sort Even and Odd Indices Independently.
     * Memory Usage: 44.7 MB, less than 69.96% of Java online submissions for Sort Even and Odd Indices Independently.
     *
     * @param nums
     * @return
     */
    public int[] sortEvenOdd(int[] nums) {
       for (int i=0;i<nums.length-1;i++){
           for (int j=i+2;j<nums.length;j+=2){
               if ((i&1)==0){
                   if (nums[i]>nums[j]){
                       swap(nums,i,j);
                   }
               } else {
                   if (nums[i]<nums[j]){
                       swap(nums,i,j);
                   }
               }
           }
       }
       return nums;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String [] args) {
        _2164_Sort_Even_and_Odd_Indices_Independently test = new _2164_Sort_Even_and_Odd_Indices_Independently();
        System.out.println(Arrays.toString(test.sortEvenOdd(new int[]{4,1,2,3})));
        System.out.println(Arrays.toString(test.sortEvenOdd(new int[]{2,1})));
        System.out.println(Arrays.toString(test.sortEvenOdd(new int[]{36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34})));
    }
}
