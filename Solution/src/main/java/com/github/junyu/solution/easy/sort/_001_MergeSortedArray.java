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
     * 首先将nums2数组合并到nums1数组，然后使用归并排序
     * @param nums1 数组1
     * @param m 数组1有效长度
     * @param nums2 数组2
     * @param n 数组2有效长度
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        sort(nums1, nums1.length);
    }

    private static int[] sort(int arr[], int length) {
        int temp[] = new int[length];
        return sortMerge(arr, 0, length - 1, temp);
    }

    private static int[] sortMerge(int arr[], int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortMerge(arr, left, mid, temp);
            sortMerge(arr, mid + 1, right, temp);
            return finalMerge(arr, left, mid, right, temp);
        }
        return null;
    }

    private static int[] finalMerge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;

        while (left <= right) {
            arr[left++] = temp[t++];
        }
        return arr;
    }

    public static void main(String[] args) {
        int m = 3,n =3;
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

//        int m =0,n =5;
//        int[] nums1 = {0, 0, 0, 0, 0};
//        int[] nums2 = {1, 2, 3, 4, 5};

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


}
