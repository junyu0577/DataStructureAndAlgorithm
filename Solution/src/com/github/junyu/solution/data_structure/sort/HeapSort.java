package com.github.junyu.solution.data_structure.sort;

import com.github.junyu.solution.data_structure.heap.MaxHeap;
import com.github.junyu.solution.data_structure.heap.MaxIndexHeap;
import com.github.junyu.solution.data_structure.heap.MaxIndexHeap2;
import com.github.junyu.solution.data_structure.heap.MinIndexHeap;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/24 15:57
 */
public class HeapSort {
//    /**
//     * 最大堆
//     * @param arr
//     * @param n
//     * @return
//     */
//    public static int[] sort(int arr[], int n) {
//
//        MaxHeap maxHeap = new MaxHeap(n);
//        int i = 0;
//        while (i < n) {
//            maxHeap.insert(arr[i]);
//            i++;
//        }
//
//        int j = n - 1;
//        while (j >= 0) {
//            arr[j] = maxHeap.remove();
//            j--;
//        }
//        return arr;
//    }

//    /**
//     * 最大索引堆
//     * @param arr
//     * @param n
//     * @return
//     */
//    public static int[] sort(int arr[], int n) {
//
//        MaxIndexHeap maxIndexHeap = new MaxIndexHeap(arr,n);
//
//        int j = n - 1;
//        while (j >= 0) {
//            arr[j] = maxIndexHeap.remove();
//            j--;
//        }
//        return arr;
//    }

//    /**
//     * 最小索引堆
//     *
//     * @param arr
//     * @param n
//     * @return
//     */
//    public static int[] sort(int arr[], int n) {
//
//        MinIndexHeap minIndexHeap = new MinIndexHeap(arr, n);
//
//        int j = 0;
//        while (j < n ) {
//            arr[j] = minIndexHeap.remove();
//            j++;
//        }
//        return arr;
//    }
//
//    public static void main(String[] args) {
//    }

    /**
     * 最大索引堆优化版
     * @param arr
     * @param n
     * @return
     */
    public static int[] sort(int arr[], int n) {

        MaxIndexHeap2 maxIndexHeap = new MaxIndexHeap2(arr,n);

        int j = n - 1;
        while (j >= 0) {
            arr[j] = maxIndexHeap.remove();
            j--;
        }
        return arr;
    }
}
