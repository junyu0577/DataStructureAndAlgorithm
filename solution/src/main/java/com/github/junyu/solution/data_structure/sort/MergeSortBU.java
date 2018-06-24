package com.github.junyu.solution.data_structure.sort;


/**
 * 归并排序-自底向上使用迭代的方式进行归并
 *
 * @author ShaoJunyu
 * @since 2018/6/15 10:53
 */
public class MergeSortBU {


    public static int[] sort(int[] arr, int length) {
        int temp[] = new int[length];

        for (int size = 1; size <= length; size += size) {
            for (int j = 0; j + size < length; j += size + size) {
                if (arr[j + size - 1] > arr[j + size])
                    mergeSort(arr, j, j + size - 1, Math.min(j + size + size - 1, length - 1), temp);
            }

        }
        return arr;
    }


    private static int[] mergeSort(int[] arr, int left, int mid, int right, int temp[]) {
        int l = left;//指向左边的数组
        int r = mid + 1;//指向后边的数组
        int t = 0;//指向临时的数组
        while (l <= mid && r <= right) {//比较左右两边的数组大小插入的temp数组中
            if (arr[l] <= arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }
        }

        while (l <= mid) {//把左边数组的剩余元素插入到temp数组中
            temp[t++] = arr[l++];
        }

        while (r <= right) {//把右边数组的剩余元素插入到temp数组中
            temp[t++] = arr[r++];
        }

        t = 0;//用临时数组的元素覆盖原数组
        while (left <= right) {
            arr[left++] = temp[t++];
        }
        return arr;
    }

}
