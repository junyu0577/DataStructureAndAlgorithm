package com.github.junyu.solution.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaoJunyu
 * @since 2018/6/13 10:58
 */
public class _007_IntersectionOfTwoArrays_II {


    /*
    Given two arrays, write a function to compute their intersection.

    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

    Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

    Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    */

    /**
     * 思路：i和j作为指针分别指向两个数组。
     * 对两个数组进行排序后，根据两个指针去遍历两个数组，分为三种情况：
     * 当两个位置得值相等时，那么两个指针都需要递增，并将值添加到集合中。
     * 当nums1得值小于nums2，需要递增指向nums1得指针i
     * 当nums1得值大于nums2，需要递增指向nums2得指针j
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i= 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i]<nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};

//        int[] nums1 = {1, 2, 3, 2, 1};
//        int[] nums2 = {2, 2};

        int[] nums1 = {2,3};
        int[] nums2 = {1,3};

//        int[] nums1 = {1};
//        int[] nums2 = {1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
