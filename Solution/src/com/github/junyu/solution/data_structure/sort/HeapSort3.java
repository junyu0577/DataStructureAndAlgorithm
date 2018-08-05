package com.github.junyu.solution.data_structure.sort;


/**
 * 原地堆-不需要开辟新的数组空间，因此空间复杂度为0(1)
 * 通过shiftDown操作，先让数组形成完全二叉树，然后每次将数组的第一个元素交换到最后，再对最后一个
 * 元素之前的所有元素进行shiftDown操作，一直交换到数组的第1个元素，完成排序的过程
 *
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018-06-24 17:32
 */
public class HeapSort3 {
    public static int[] sort(int arr[], int n) {

        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            shiftDown(arr, i, 0);
        }

        return arr;
    }

    private static void shiftDown(int[] arr, int n, int index) {
        int value = arr[index];
        while (index * 2 + 1 < n) {//有左孩子的情况
            int leftChild = index * 2 + 1;
            if (leftChild + 1 < n && arr[leftChild + 1] > arr[leftChild]) {//有右孩子并且又孩子大于左孩子
                leftChild += 1;
            }

            if (value >= arr[leftChild]) {//父节点大于子结点
                break;
            }
            arr[index] = arr[leftChild];//使用优化插入排序的思路，减少结点间的swap操作，提升效率
            index = leftChild;
        }
        arr[index] = value;
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
    }

}
