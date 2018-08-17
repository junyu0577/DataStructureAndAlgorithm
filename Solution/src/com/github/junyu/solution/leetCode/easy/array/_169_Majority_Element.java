package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169_Majority_Element {


/*
    Given an array of size n, find the majority element.
    The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example 1:

    Input: [3,2,3]
    Output: 3
    Example 2:

    Input: [2,2,1,1,1,2,2]
    Output: 2*/


//    /**
//     * 求众数,众数是指在数组中出现次数大于 [n/2] 的元素。
//     * 用HashMap记录出现的数字已经出现的次数，迭代返回超过n/2的元素
//     *
//     * @param nums
//     * @return
//     */
//    public int majorityElement(int[] nums) {
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.get(nums[i]) == null)
//                map.put(nums[i], 1);
//            else {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > nums.length / 2) {
//                return entry.getKey();
//            }
//        }
//
//        return -1;
//
//    }

    /**
     * 解法二
     * 根据元素数量超过一半的特征，那么对一个经过排序的元素，中间位置的元素必然是众数
     * 时间复杂度为o(nlogn)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }


    public static void main(String[] args) {
        int arr[] = {2, 2, 1, 1, 1, 2, 2};
//        int arr [] = {3,2,3};
//        int arr [] = {4,5,4};
//        int arr [] = {-1,1,1,1,2,1};
        _169_Majority_Element majority_element = new _169_Majority_Element();
        System.out.println(majority_element.majorityElement(arr));
    }

}
