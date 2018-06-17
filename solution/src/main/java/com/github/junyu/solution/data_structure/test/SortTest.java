package com.github.junyu.solution.data_structure.test;

import com.github.junyu.solution.data_structure.sort.BubbleSort;
import com.github.junyu.solution.data_structure.sort.InsertionSort;
import com.github.junyu.solution.data_structure.sort.MergeSort;
import com.github.junyu.solution.data_structure.sort.QuickSort;
import com.github.junyu.solution.data_structure.sort.SelectionSort;

import java.util.Arrays;

/**
 * @author ShaoJunyu
 * @since 2018/6/15 08:57
 */
public class SortTest {


    private static long startTime;

    public static void main(String[] args) {

        int length = 11;
        int[] arr = generateArr(length);
//        int[] arr = generateRandomArr(length, 0, length);
//        int [] arr1 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr));

        startAnalyse();
//        System.out.println(Arrays.toString(InsertionSort.insertionSort(arr, arr.length)));
//        System.out.println(Arrays.toString(SelectionSort.selectSort(arr, arr.length)));
//        System.out.println(Arrays.toString(BubbleSort.bubbleSort(arr, arr.length)));

        System.out.println(Arrays.toString(QuickSort.quickSort(arr, arr.length)));
        costAnalyse();
//        System.out.println(Arrays.toString(MergeSort.sort(arr, arr.length)));
//        costAnalyse();

    }

    private static void startAnalyse() {
        startTime = System.currentTimeMillis();
    }

    private static void costAnalyse() {
        System.err.println("\ncost:" + (float) (System.currentTimeMillis() - startTime) / 1000 + "s");
        startAnalyse();
    }

    private static int[] generateArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = length;
            length--;
        }
        return arr;
    }

    public static int[] generateRandomArr(int n, int min, int max) {

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        }

        return arr;
    }


}
