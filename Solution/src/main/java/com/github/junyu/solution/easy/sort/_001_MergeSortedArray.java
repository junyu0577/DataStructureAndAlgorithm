package com.github.junyu.solution.easy.sort;

import java.util.Arrays;

/**
 * @author ShaoJunyu
 * @since 2018/6/15 15:30
 */
public class _001_MergeSortedArray {

   /*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    Example:

    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]
    */


    /**
     * 思路：因为两个数组都是有序的，直接用归并排序的合并逻辑。
     *
     * @param nums1 数组1
     * @param m     数组1有效长度
     * @param nums2 数组2
     * @param n     数组2有效长度
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int t = 0;

        int temp[] = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] >= nums2[j]) {
                temp[t++] = nums2[j++];
            } else {
                temp[t++] = nums1[i++];
            }
        }

        while (i < m) {
            temp[t++] = nums1[i++];
        }
        while (j < n) {
            temp[t++] = nums2[j++];
        }

        t = 0;
        while (t < nums1.length) {
            nums1[t] = temp[t];
            t++;
        }
    }

    public static void main(String[] args) {
//        int m = 3, n = 3;
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};

        int m =0,n =5;
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 4, 5};

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


}
