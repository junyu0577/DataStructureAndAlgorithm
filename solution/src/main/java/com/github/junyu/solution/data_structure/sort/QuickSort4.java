package com.github.junyu.solution.data_structure.sort;


/**
 * 三路快速排序,在存在大量重复的元素的数组里，效率更高
 * 定义了三个指针lt、gt、i分别指向小于target，大于target和等于target部分的最后一个元素。
 * 因为每次在递归的时候忽略了等于target的部分，所以效率要高于二路快速排序
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018-06-24 18:48
 */
public class QuickSort4 {


    public static int[] sort(int arr[], int n) {
        return quickSort(arr, 0, n - 1);
    }


    private static int[] quickSort(int arr[], int left, int right) {
        if (left < right) {

            //partition
            swap(arr, left, (int) (Math.random() * (right - left + 1) + left));

            int target = arr[left];

            int lt = left;
            int gt = right + 1;
            int i = lt + 1;
            while (i < gt) {
                if (arr[i] < target) {
                    swap(arr, i, lt + 1);
                    lt++;
                    i++;
                } else if (arr[i] == target) {
                    i++;
                } else {
                    swap(arr, i, gt - 1);
                    gt--;
                }
            }
            swap(arr, left, lt);
            quickSort(arr, left, lt - 1);
            quickSort(arr, gt, right);

        }
        return arr;
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
