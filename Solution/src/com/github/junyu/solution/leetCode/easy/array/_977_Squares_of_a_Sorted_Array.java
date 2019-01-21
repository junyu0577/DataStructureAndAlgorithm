package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _977_Squares_of_a_Sorted_Array {

   /* Given an array of integers A sorted in non-decreasing order,
    return an array of the squares of each number, also in sorted non-decreasing order.

    Example 1:

    Input: [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Example 2:

    Input: [-7,-3,2,3,11]
    Output: [4,9,9,49,121]


    Note:

            1 <= A.length <= 10000
            -10000 <= A[i] <= 10000
    A is sorted in non-decreasing order.
*/

    /**
     * 将一个升序的数组的每个元素变成他的平方后以升序返回结果
     * 遍历数组求每个元素的平方后，再进行一次排序。
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {

        for (int i = 0; i < A.length; i++) {
            A[i] = A[i]*A[i];
        }

        Arrays.sort(A);

        return A;

    }

    public static void main(String[] args) {
        _977_Squares_of_a_Sorted_Array squares_of_a_sorted_array = new _977_Squares_of_a_Sorted_Array();
        System.out.println(Arrays.toString(squares_of_a_sorted_array.sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(squares_of_a_sorted_array.sortedSquares(new int[]{-7,-3,2,3,11})));
    }
}
