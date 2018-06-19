package com.github.junyu.solution.data_structure.sort;


/**
 * 快速排序优化，如果对一个近乎有序的数组进行排序，那么有可能会使得时间复杂度逼近O(n^2)。
 * 将每次用于比较的target进行随机采样，而不是每次固定的取第一个元素，会增强稳定性
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/17 16:12
 */
public class QuickSort2 {


    public static int[] sort(int arr[], int n) {
        return quickSort(arr, 0, n - 1);
    }

    private static int partition(int arr[], int left, int right) {

        swap(arr,left,(int)(Math.random()*(right-left+1)+left));

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
