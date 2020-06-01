package com.github.junyu.solution.leetCode.easy.array;

public class _1287_Element_Appearing_More_Than_25_Percent_In_Sorted_Array {

    /*Given an integer array sorted in non-decreasing order, there is exactly one
    integer in the array that occurs more than 25% of the time.

    Return that integer.
    Example 1:

    Input: arr = [1,2,2,6,6,6,6,7,10]
    Output: 6

    Constraints:

            1 <= arr.length <= 10^4
            0 <= arr[i] <= 10^5*/

    /**
     * 找出出现次数超过总量25%的元素
     * 思路：遍历数组的同时，统计出现最多次数的元素以及数量,如果发现有元素的数量超过25%，那么更新ans的值，并
     * 结束循环。
     *
     * @param arr
     * @return
     */
    public int findSpecialInteger(int[] arr) {
        int ans = arr[0];
        int curCount = 0;
        int len = arr.length/4;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                curCount++;
            } else {
                curCount = 0;
            }
            if (curCount >= len) {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _1287_Element_Appearing_More_Than_25_Percent_In_Sorted_Array test =
                new _1287_Element_Appearing_More_Than_25_Percent_In_Sorted_Array();
//        System.out.println(test.findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
//        System.out.println(test.findSpecialInteger(new int[]{1}));
//        System.out.println(test.findSpecialInteger(new int[]{1, 2, 2}));
//        System.out.println(test.findSpecialInteger(new int[]{1, 1, 2}));
//        System.out.println(test.findSpecialInteger(new int[]{1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 4, 5, 6}));
        System.out.println(test.findSpecialInteger(new int[]{1,2,3,3}));
    }
}
