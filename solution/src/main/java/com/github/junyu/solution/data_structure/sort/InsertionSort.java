package com.github.junyu.solution.data_structure.sort;



/**
 * 插入排序
 *
 * @author ShaoJunyu
 * @since 2018/6/15 08:46
 */
public class InsertionSort {

    public static int[] sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
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
