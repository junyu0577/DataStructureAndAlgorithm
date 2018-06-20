package com.github.junyu.solution.data_structure.sort;

/**
 * 希尔排序-插入排序算法
 * 核心就是通过设立一个h增量，这个增量的初始值取决于数组的长度，越长则越大。
 * 通过增量进行循环里层的插排，每次循环时，总是对[j-h]和[j]所在位置的元素进行比较并排序。
 * 里层的插排循环结束再将增量h做/3处理,当h大于等于1是，继续执行里层的插排。如此，整个数组变得基本有序。
 * 当增量h减小到1时，就和普通的插入排序一样，但是此时的数组已经基本有序，再次进行排列时效率非常高。
 *
 * @author ShaoJunyu
 * @since 2018/6/20 15:52
 */
public class ShellSort {

    public static int[] sort(int arr[], int n) {
        return shellSort(arr, n);
    }

    private static int[] shellSort(int arr[], int n) {

        int h = 1;

        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {

            for (int i = h; i < n; i++) {
                int j = i;
                int value = arr[j];
                for (; j >= h && value < arr[j - h]; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = value;
            }

            h = h/3;

        }

        return arr;
    }

}
