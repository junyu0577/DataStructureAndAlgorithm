package com.github.junyu.solution.leetCode.easy.array;

import java.util.*;

public class _1089_Duplicate_Zeros {

   /* Given a fixed length array arr of integers, duplicate each occurrence of zero,
    shifting the remaining elements to the right.

    Note that elements beyond the length of the original array are not written.

    Do the above modifications to the input array in place, do not return anything
    from your function.

    Example 1:

    Input: [1,0,2,3,0,4,5,0]
    Output: null
    Explanation: After calling your function, the input array is
    modified to: [1,0,0,2,3,0,0,4]
    Example 2:

    Input: [1,2,3]
    Output: null
    Explanation: After calling your function, the input array is modified to: [1,2,3]

    Note:

            1 <= arr.length <= 10000
            0 <= arr[i] <= 9*/

    /**
     * 复制数组中为0的元素，复制后原来的元素位置全部后移
     * 思路：复制一份数组出来，然后每次从改数组中取一个数出来，如果是0，那么就往arr中插入两个0，
     * 同时维护好count，增加两个。如果不是0，则将当前的元素插入到arr中。
     * 结束条件设置为length-1是由于最后插入的元素可能为0，存在越界的位置，因此如果最后插入的元素不是0，
     * 那么还需要额外从newArr中取出一个元素插入到arr中。
     *
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        int count = 0;
        int p = 0;
        while (count < arr.length - 1) {
            if (newArr[p] == 0) {
                arr[count++] = 0;
                arr[count++] = 0;
                p++;
            } else {
                arr[count++] = newArr[p++];
            }
        }
        if (count < arr.length)
            arr[count] = newArr[p];
    }

    public static void main(String[] args) {
        _1089_Duplicate_Zeros test = new _1089_Duplicate_Zeros();
        test.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        test.duplicateZeros(new int[]{1, 0});
        test.duplicateZeros(new int[]{1, 2, 3});
        test.duplicateZeros(new int[]{1, 5, 2, 0, 6, 8, 0, 6, 0});
    }
}
