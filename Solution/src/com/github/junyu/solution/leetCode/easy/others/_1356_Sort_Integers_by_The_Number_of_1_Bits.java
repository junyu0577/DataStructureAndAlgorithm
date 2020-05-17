package com.github.junyu.solution.leetCode.easy.others;

import java.util.*;

public class _1356_Sort_Integers_by_The_Number_of_1_Bits {

   /* Given an integer array arr. You have to sort the integers in the array in ascending order by the
    number of 1's in their binary representation and in case of two or more integers have the same number of 1's
    you have to sort them in ascending order.

    Return the sorted array.

    Example 1:

    Input: arr = [0,1,2,3,4,5,6,7,8]
    Output: [0,1,2,4,8,3,5,6,7]
    Explantion: [0] is the only integer with 0 bits.
    [1,2,4,8] all have 1 bit.
    [3,5,6] have 2 bits.
    [7] has 3 bits.
    The sorted array by bits is [0,1,2,4,8,3,5,6,7]
    Example 2:

    Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
    Output: [1,2,4,8,16,32,64,128,256,512,1024]
    Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
    Example 3:

    Input: arr = [10000,10000]
    Output: [10000,10000]
    Example 4:

    Input: arr = [2,3,5,7,11,13,17,19]
    Output: [2,3,5,17,7,11,13,19]
    Example 5:

    Input: arr = [10,100,1000,10000]
    Output: [10,100,10000,1000]


    Constraints:

            1 <= arr.length <= 500
            0 <= arr[i] <= 10^4*/


    /**
     * 使用快排时，修改一些partition的逻辑，原来的partition只是根据元素的大小获取索引位,而现在加入二进制位数的条件，
     * 如果当前元素的二进制位数小于target的或者位数相同，当是当前元素的值较小，那么就需要交换位置。
     *
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

      int target = arr[left];
      int mid = left;
      int targetOneCount = Integer.bitCount(target);
      for (int i=left+1;i<=right;i++){
          int curTargetCount = Integer.bitCount(arr[i]);
          if (curTargetCount<targetOneCount || (curTargetCount==targetOneCount && arr[i]<target)){
            swap(arr,++mid,i);
          }
      }
      swap(arr,left,mid);
      quickSort(arr,left,mid-1);
      quickSort(arr,mid+1,right);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    /**
//     * 根据数字的二进制下的1的数量进行排序
//     * 思路：利用数组的排序，先比较二进制下1的数量，如果相等继续比较自身的大小。
//     * 由于存在两次额外的数组赋值以及这个过程中的额外的装箱和拆箱操作，效率不如直接
//     * 使用快排高
//     * @param arr
//     * @return
//     */
//    public int[] sortByBits(int[] arr) {
//        Integer[] newArr = new Integer[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            newArr[i] = arr[i];
//        }
//        Arrays.sort(newArr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                int result = getOneCount(o1) - getOneCount(o2);
//                if (result != 0)
//                    return result;
//
//                return o1 - o2;
//            }
//        });
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = newArr[i];
//        }
//        return arr;
//    }
//
//    private int getOneCount(int num) {
//        int count = 0;
//        while (num > 0) {
//            count += num & 1;
//            num = num >> 1;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        _1356_Sort_Integers_by_The_Number_of_1_Bits test = new _1356_Sort_Integers_by_The_Number_of_1_Bits();
//        System.out.println(Arrays.toString(test.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
//        System.out.println(Arrays.toString(test.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
//        System.out.println(Arrays.toString(test.sortByBits(new int[]{10000, 10000})));
//        System.out.println(Arrays.toString(test.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19})));
        System.out.println(Arrays.toString(test.sortByBits(new int[]{10, 100, 1000, 10000})));
    }


}
