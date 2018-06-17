package com.github.junyu.solution.data_structure.sort;


/**
 * 插入排序
 *
 * @author ShaoJunyu
 * @since 2018/6/15 08:46
 */
public class InsertionSort {

    public static int[] insertionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }
}
