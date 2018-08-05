package com.github.junyu.solution.data_structure.sort;



/**
 * 选择排序
 *
 * @author ShaoJunyu
 * @since 2018/6/15 08:51
 */
public class SelectionSort {

    public static int[] sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
        return arr;
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
    }
}
