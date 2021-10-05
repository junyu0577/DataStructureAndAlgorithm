package com.github.junyu.solution.leetCode.easy.array;

import com.github.junyu.solution.data_structure.utils.ArrayMaker;

public class _2022_Convert_1D_Array_Into_2D_Array {

   /*
    You are given a 0-indexed 1-dimensional (1D) integer array original,
     and two integers, m and n. You are tasked with creating a 2-dimensional
      (2D) array with m rows and n columns using all the elements from original.

    The elements from indices 0 to n - 1 (inclusive) of original should form
    the first row of the constructed 2D array, the elements from
    indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.

    Return an m x n 2D array constructed according to the above procedure,
    or an empty 2D array if it is impossible.


    Example 1:

    Input: original = [1,2,3,4], m = 2, n = 2
    Output: [[1,2],[3,4]]
    Explanation:
    The constructed 2D array should contain 2 rows and 2 columns.
    The first group of n=2 elements in original, [1,2], becomes
    the first row in the constructed 2D array.
    The second group of n=2 elements in original, [3,4], becomes
     the second row in the constructed 2D array.

    Example 2:

    Input: original = [1,2,3], m = 1, n = 3
    Output: [[1,2,3]]
    Explanation:
    The constructed 2D array should contain 1 row and 3 columns.
    Put all three elements in original into the first row of the
    constructed 2D array.

    Example 3:

    Input: original = [1,2], m = 1, n = 1
    Output: []
    Explanation:
    There are 2 elements in original.
    It is impossible to fit 2 elements in a 1x1 2D array, so return
     an empty 2D array.

    Example 4:

    Input: original = [3], m = 1, n = 2
    Output: []
    Explanation:
    There is 1 element in original.
    It is impossible to make 1 element fill all the spots in a 1x2 2D
    array, so return an empty 2D array.


            Constraints:

            1 <= original.length <= 5 * 104
            1 <= original[i] <= 105
            1 <= m, n <= 4 * 104
    */


    /**
     * 将一维数组变为二维数组
     *
     * 用curRow和curCol标示起始的位置，当curCol=n时说明元素正好满足一行需要进行换行。
     *
     * Runtime: 4 ms, faster than 90.44% of Java online submissions for Convert 1D Array Into 2D Array.
     * Memory Usage: 49.7 MB, less than 75.77% of Java online submissions for Convert 1D Array Into 2D Array.
     *
     * @param original
     * @param m
     * @param n
     * @return
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m*n!=original.length)
            return new int[][]{};

        int [][] ans = new int[m][n];

        int curRow = 0;
        int curCol = 0;
        for (int i=0;i<original.length;i++){
            ans[curRow][curCol]  = original[i];
            curCol++;
            if (curCol==n){
                curCol = 0;
                curRow++;
            }
        }

        return ans;
    }


    public static void main(String [] args) {
        _2022_Convert_1D_Array_Into_2D_Array test = new _2022_Convert_1D_Array_Into_2D_Array();
        ArrayMaker.print2DArray(test.construct2DArray(new int[]{1,2,3,4},2,2),2,2);
        ArrayMaker.print2DArray(test.construct2DArray(new int[]{1,2,3},1,3),1,3);
        ArrayMaker.print2DArray(test.construct2DArray(new int[]{1,2},1,1),1,1);
        ArrayMaker.print2DArray(test.construct2DArray(new int[]{3},1,2),1,2);
    }
}
