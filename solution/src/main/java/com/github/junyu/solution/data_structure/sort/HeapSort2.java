package com.github.junyu.solution.data_structure.sort;

import com.github.junyu.solution.data_structure.heap.MaxHeap;

/**
 * 堆排序优化，通过Heapify数组建堆代替原先的insert逐个插入
 * heapify过程时间复杂度0(n)，而insert的时间复杂度为0(nlogn)
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/24 15:57
 */
public class HeapSort2 {
    public static int[] sort(int arr[], int n) {

        MaxHeap maxHeap = new MaxHeap(arr, n);

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
