package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _349_Intersection_of_Two_Arrays {

   /* Given two arrays, write a function to compute their intersection.

            Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]
    Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Note:

    Each element in the result must be unique.
    The result can be in any order.*/

    /**
     * 判断两个数组的交集，返回的数组中不能存有重复元素
     * 使用hashset保存nums1中出现过的数，再遍历nums2数组，如果在hashset中存在，就是交集部分的元素，加入到res中，然后再从hashset中删除元素，去重。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return new int[0];
        if (nums2 == null || nums2.length == 0)
            return new int[0];

        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                res.add(nums2[i]);
                hashSet.remove(nums2[i]);
            }
        }
        int arr[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            arr[i] = res.get(i);

        return arr;

    }

    public static void main(String[] args) {
        _349_Intersection_of_Two_Arrays intersection_of_two_arrays = new _349_Intersection_of_Two_Arrays();
        System.out.println(Arrays.toString(intersection_of_two_arrays.intersection(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(intersection_of_two_arrays.intersection(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
}
