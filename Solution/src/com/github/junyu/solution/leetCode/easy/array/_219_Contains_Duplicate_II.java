package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashMap;

public class _219_Contains_Duplicate_II {

   /* Given an array of integers and an integer k, find out whether there are two distinct
    indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

    Example 1:

    Input: nums = [1,2,3,1], k = 3
    Output: true
    Example 2:

    Input: nums = [1,0,1,1], k = 1
    Output: true
    Example 3:

    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false*/

    /**
     * 。
     * 解法二思路：利用滑动窗口算法，先右移指针，直到找到重复的元素，然后看看他们的间隔是否小于等于k，满足则返回true。
     * 利用hashMap的put方法的返回值，put时，如果已经存在有相同的key，在覆盖的同时还会返回上一个key对应的value，那么通过这个value也就是上一个
     * 相同元素出现的位置减去当前指针的位置的绝对值小于等于k即满足条件，反之，则继续遍历数组查找相同的元素.
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int point = 0, len = nums.length;
        HashMap<Integer, Integer> numMap = new HashMap<>();
        while (point < len) {
            Integer lastValue = numMap.put(nums[point], point);
            if (lastValue != null && Math.abs(lastValue - point) <= k)
                return true;

            point++;
        }
        return false;
    }

//    /**
//     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
//     * 解法一思路：利用滑动窗口算法，先右移指针，直到找到重复的元素，然后看看他们的间隔是否小于等于k，满足则返回true。
//     * 如果找到了重复的元素，但是不符合条件，那么意味着就算后续出现了重复的也不会满足条件，直接从map删除最初插入的，再插入当前的元素以及对应的位置
//     * ，然后指针继续右移，开始下一轮的匹配。
//     *
//     * @param nums
//     * @param k
//     * @return
//     */
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        int point = 0, len = nums.length;
//        HashMap<Integer, Integer> numMap = new HashMap<>();
//        while (point < len) {
//            if (numMap.get(nums[point]) != null) {
//                if (Math.abs(numMap.get(nums[point]) - point) <= k)
//                    return true;
//
//                numMap.remove(nums[point]);
//            }
//            numMap.put(nums[point], point);
//            point++;
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        _219_Contains_Duplicate_II test = new _219_Contains_Duplicate_II();
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
