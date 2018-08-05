package com.github.junyu.solution.data_structure.sort;

/**
 * 冒泡排序
 *
 * @author ShaoJunyu
 * @since 2018/6/15 08:51
 */
public class BubbleSort {

    public static int[] sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
    }
}
