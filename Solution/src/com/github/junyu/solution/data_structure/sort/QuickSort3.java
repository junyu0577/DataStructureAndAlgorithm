package com.github.junyu.solution.data_structure.sort;


import java.util.Arrays;

/**
 * 二路快速排序，对于数组中存在大量重复的元素，普通的快排在partition时可能会出现极其不平衡的状况，
 * 最终导致退化到O(n^2)。
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/6/17 16:12
 */
public class QuickSort3 {


    public static int[] sort(int arr[], int n) {
        return quickSort(arr, 0, n - 1);
    }

    private static int partition(int arr[], int left, int right) {

        swap(arr, left, (int) (Math.random() * (right - left + 1) + left));

        int target = arr[left];

       int i = left+1;
       int j = right;
       while (true){
           while (i<=right && arr[i]<target)
               i++;

           while (j>=left+1 && arr[j]>target)
               j--;

           if (i>j)
               break;

           swap(arr,i,j);
           i++;
           j--;
       }
       swap(arr,left,j);
       return j;
    }


    private static int[] quickSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
        return arr;
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
