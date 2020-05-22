package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _1299_Replace_Elements_with_Greatest_Element_on_Right_Side {


    /*Given an array arr, replace every element in that array with the
    greatest element among the elements to its right, and replace the last element with -1.

    After doing so, return the array.

    Example 1:

    Input: arr = [17,18,5,4,6,1]
    Output: [18,6,6,6,1,-1]


    Constraints:

            1 <= arr.length <= 10^4
            1 <= arr[i] <= 10^5*/

    /**
     * 将每个元素替换为右侧最大元素
     * 思路：从数组尾部开始遍历，每次将上一次保存的最大值赋值给当前元素，如果当前元素大于最大值，则
     * 更新最大值。
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        arr[arr.length-1] = -1;
        for (int i=arr.length-2;i>=0;i--){
            int value = arr[i];
            arr[i] = max;
            max = Math.max(max,value);
        }
        return arr;
    }

    public static void main(String [] args) {
        _1299_Replace_Elements_with_Greatest_Element_on_Right_Side test = new _1299_Replace_Elements_with_Greatest_Element_on_Right_Side();
        System.out.println(Arrays.toString(test.replaceElements(new int[]{17,18,5,4,6,1})));
    }
}
