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
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
