package com.github.junyu.solution.data_structure.sort;


/**
 * 快速排序
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/17 16:12
 */
public class QuickSort {


    public static int[] quickSort(int arr[], int n) {
        return quickSort(arr, 0, n - 1);
    }

    private static int partition(int arr[], int left, int right) {
        int target = arr[left];
        int j = left;
        for (int i = j + 1; i <= right; i++) {
            if (arr[i] < target) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, j, left);
        return j;
    }


    private static int[] quickSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
        return arr;
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
