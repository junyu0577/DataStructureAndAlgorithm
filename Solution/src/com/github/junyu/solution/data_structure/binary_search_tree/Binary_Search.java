package com.github.junyu.solution.data_structure.binary_search_tree;

/**
 * 二分查找
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/28 20:29
 */
public class Binary_Search {

    public static int search(int[] arr, int n, int key) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(search(arr, arr.length, i));
        }
        System.out.println(search(arr, arr.length, arr.length + 1));
    }
}
