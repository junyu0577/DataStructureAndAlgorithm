package com.github.junyu.solution.leetCode.easy.array;

public class _941_Valid_Mountain_Array {


   /* Given an array A of integers, return true if and only if it is a valid mountain array.

    Recall that A is a mountain array if and only if:

    A.length >= 3
    There exists some i with 0 < i < A.length - 1 such that:
    A[0] < A[1] < ... A[i-1] < A[i]
    A[i] > A[i+1] > ... > A[B.length - 1]

    Example 1:

    Input: [2,1]
    Output: false
    Example 2:

    Input: [3,5,5]
    Output: false
    Example 3:

    Input: [0,3,2,1]
    Output: true


    Note:

    0 <= A.length <= 10000
    0 <= A[i] <= 10000


    */

    /**
     * 验证是否是有效的山脉数组（先升序再降序）
     * 先通过while一层循环进行过滤，如果峰值在开始或者末尾都是无效的。
     * 然后再用while循环进行降序的过滤，最后如果最小值在数组末尾，就说明符合条件了。
     *
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int len = A.length - 1;
        int i = 0;
        while (i + 1 <= len && A[i] < A[i + 1]) {
            i++;
        }

        if (i == 0 || i == len)
            return false;

        while (i + 1 <= len && A[i] > A[i + 1]) {
            i++;
        }

        return i == len;
    }


    public static void main(String[] args) {
        _941_Valid_Mountain_Array valid_mountain_array = new _941_Valid_Mountain_Array();
        System.out.println(valid_mountain_array.validMountainArray(new int[]{2, 1}));
        System.out.println(valid_mountain_array.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(valid_mountain_array.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(valid_mountain_array.validMountainArray(new int[]{1, 3, 2}));
    }


}
