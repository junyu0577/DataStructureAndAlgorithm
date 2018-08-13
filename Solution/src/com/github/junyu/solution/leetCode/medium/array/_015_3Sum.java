package com.github.junyu.solution.leetCode.medium.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015_3Sum {

/*
    Given an array nums of n integers, are there elements a, b, c in
    nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

            Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
            [
            [-1, 0, 1],
            [-1, -1, 2]
            ]
    */


    /**
     * 求出集合中三数之和为0的组合
     * 首先对数组进行一个排序（不然会给组合去重造成额外的开销），遍历数组，只需要遍历完倒数第三个数即可，因为末尾两个数已经不满足条件。
     * 当前要遍历的元素如果和上一个相同，那么跳过，不然会出现重复的组合。
     * 定义target去保存当前遍历到元素的结果取负，这样后续left+right的和一旦等于target，就说明三数之和为0。
     * left和right分别指向当前遍历到的元素的next和末尾。
     * 如果target>left和right的和，就右移left。
     * target<left+right，就左移动。
     * 在相等的情况下，就说明找到一组集合，添加完以后还需要left++和right--操作，进行下一组的比对。不过比对之前
     * 还需要进行一下去重，就是右移后的元素和上一个元素相等或者末尾左移后的元素和它的下一个元素相等，就是重复的组合，需要略过。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])//当前的和上一个元素重复 略过
                continue;

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (target > nums[left] + nums[right])//left指针左移
                    left++;
                else if (target < nums[left] + nums[right])//right指针右移
                    right--;
                else {//找到组合
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])//右移后，元素和上一个重复 略过
                        left++;

                    while (left < right && nums[right] == nums[right + 1])//末尾左移后，和下一个元素重复 略过
                    right--;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
//        int arr[] = {-1, 0, 1, 2, -1, -4};
//        int arr[] = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int arr[] = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
//        int arr[] = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        _015_3Sum sum = new _015_3Sum();
        System.out.println(sum.threeSum(arr));
    }


}
