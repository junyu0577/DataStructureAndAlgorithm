package com.github.junyu.solution.data_structure.sort;


/**
 * 优化归并排序
 * 对于近乎有序的数组，可以在merge时加入判断，当左边的数组的最后一个元素大于右边数组的第一个元素，
 * 那么才需要进行合并，因为两个的数组的sort时就已经是有序的。
 * 第二个优化是当数组的长度在小于等于16个元素时，使用插入排序，也能在一定程度上提高效率
 *
 * @author ShaoJunyu
 * @since 2018/6/15 10:53
 */
public class MergeSort2 {


    public static int[] sort(int[] arr, int length) {
        int temp[] = new int[length];
        return sort(arr, 0, length - 1, temp);
    }

    private static int[] sort(int[] arr, int left, int right, int[] temp) {

        if (right - left <= 15) {
            return InsertionSort2.sort(arr, left, right);
        }

//        if (left >= right) {
//            return null;
//        }

        int mid = (left + right) / 2;
        sort(arr, left, mid, temp);//拆分
        sort(arr, mid + 1, right, temp);//拆分
        if (arr[mid] > arr[mid + 1])
            return mergeSort(arr, left, mid, right, temp);//归并

        return null;
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
