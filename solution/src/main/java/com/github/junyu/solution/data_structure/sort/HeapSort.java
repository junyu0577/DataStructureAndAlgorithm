package com.github.junyu.solution.data_structure.sort;

import com.github.junyu.solution.data_structure.heap.MaxHeap;

/**
 * 堆排序
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/24 15:57
 */
public class HeapSort {
    public static int[] sort(int arr[], int n) {

        MaxHeap maxHeap = new MaxHeap(n);
        int i = 0;
        while (i < n) {
            maxHeap.insert(arr[i]);
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
    }
}
