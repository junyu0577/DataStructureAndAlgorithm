package com.github.junyu.solution.leetCode.medium.array;

import java.util.TreeSet;

public class _220_Contains_Duplicate_III {

   /* Given an array of integers, find out whether there are two distinct indices i and j
    in the array such that the absolute difference between nums[i] and nums[j] is at most
    t and the absolute difference between i and j is at most k.

    Example 1:

    Input: nums = [1,2,3,1], k = 3, t = 0
    Output: true
    Example 2:

    Input: nums = [1,0,1,1], k = 1, t = 2
    Output: true
    Example 3:

    Input: nums = [1,5,9,1,5,9], k = 2, t = 3
    Output: false*/

    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     * 思路：利用窗口滑动算法，定义一个treeSet，我们最多只会往集合中添加k个元素，如果超过k个就删除集合中的第一个元素.
     * 然后遍历数组的时候，每次从set中去取和当前元素最接近的最大和最小值，ceil取的是比当前元素大的最小元素，floor取的是比当前元素小的最大元素，
     * 如果这两个值不为空并且和当前元素的差值小于等于t，那么就符合条件了。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int point = 0, len = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        while (point < len) {

            long value = nums[point];
            Long ceil = set.ceiling(value);
            Long floor = set.floor(value);

            if (ceil != null && ceil - value <= t)
                return true;

            if (floor != null && value - floor <= t)
                return true;

            set.add((long) nums[point]);
            if (set.size() == k + 1) {
                set.remove((long)nums[point - k]);
            }
            point++;
        }
        return false;
    }

    public static void main(String[] args) {
        _220_Contains_Duplicate_III test = new _220_Contains_Duplicate_III();
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(test.containsNearbyAlmostDuplicate(new int[]{10, 15, 18, 24}, 3, 3));
    }
}
