package com.github.junyu.solution.data_structure.sort;


/**
 * 插入排序优化
 * 定义的value用于保存当前的目标元素，然后j为value应该插入的位置。
 * 每次用value去比较value之前的元素，比他大的则将j-1的值赋值给j。在循环结束后，value再插入到j的位置。
 * 通过降低交换的次数，改为直接赋值，提升程序的效率。由于插入排序有提前终止的特性(对于基本有序的数组)，所以整体效率也要高于选择
 *
 * @author ShaoJunyu
 * @date 2018/6/20 13:29
 */
public class InsertionSort2 {

    public static int[] sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int value = arr[i + 1];
            int j = i + 1;
            for (; j > 0 && value < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = value;
        }
        return arr;
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
    }


    /**
     * 对数组指定区域的元素进行插入排序
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] sort(int arr[], int left, int right) {
        for (int i = left; i <= right; i++) {
            int value = arr[i + 1];
            int j = i + 1;
            for (; j > 0 && value < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = value;
        }
        return arr;
    }
}
