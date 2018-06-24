package com.github.junyu.solution.data_structure.heap;

import java.util.Arrays;

/**
 * 最大索引堆排序-验证最大索引堆的正确性
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/24 15:57
 */
public class MaxIndexHeapSort {
    public static int[] sort(int arr[], int n) {

        MaxIndexHeap maxHeap = new MaxIndexHeap(n);
        int i = 0;
        while (i < n) {
            maxHeap.insert(i, arr[i]);
            i++;
        }

        int j = n - 1;
        while (j >= 0) {
            arr[j] = maxHeap.remove();
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(MaxIndexHeapSort.sort(arr, arr.length)));
    }
}
