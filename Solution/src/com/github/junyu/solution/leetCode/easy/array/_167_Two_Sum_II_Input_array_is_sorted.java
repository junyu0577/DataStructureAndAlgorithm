package com.github.junyu.solution.leetCode.easy.array;


import java.util.Arrays;

public class _167_Two_Sum_II_Input_array_is_sorted {


/*
    Given an array of integers that is already sorted in ascending order,
    find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that
    they add up to the target, where index1 must be less than index2.

            Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.
    Example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.*/


    /**
     * 在已经排好序的数组中找到两数和为target的,返回两个数的索引+1
     * 定义两个指针，分别指向头和尾，相加后与target比大小，大了就让尾部的指针--，小了就让头部的指针++
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (target == numbers[left] + numbers[right]) {
                return new int[]{left+1, right+1};
            } else if (target > numbers[left] + numbers[right]) {
                left++;
            } else {
                right--;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;
        _167_Two_Sum_II_Input_array_is_sorted two_sum_ii_input_array_is_sorted = new _167_Two_Sum_II_Input_array_is_sorted();
        System.out.println(Arrays.toString(two_sum_ii_input_array_is_sorted.twoSum(arr, target)));
    }

}
