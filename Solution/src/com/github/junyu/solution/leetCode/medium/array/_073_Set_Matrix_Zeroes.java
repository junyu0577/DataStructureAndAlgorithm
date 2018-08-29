package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;
import java.util.HashSet;

public class _073_Set_Matrix_Zeroes {

  /*  Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

            Example 1:

    Input:
            [
            [1,1,1],
            [1,0,1],
            [1,1,1]
            ]
    Output:
            [
            [1,0,1],
            [0,0,0],
            [1,0,1]
            ]
    Example 2:

    Input:
            [
            [0,1,2,0],
            [3,4,5,2],
            [1,3,1,5]
            ]
    Output:
            [
            [0,0,0,0],
            [0,4,5,0],
            [0,3,1,0]
            ]
    Follow up:

    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?*/

    /**
     * 将矩阵中0所在的行和列的所有元素都置为0
     * 先整体遍历一下二维数字，统计哪一行哪一列出现过0，存到rows和cols集合中。
     * 再分别遍历rows和cols，将对应行和列上所有的元素置为0。
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet();
        HashSet<Integer> cols = new HashSet();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int cur : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[cur][j] = 0;
            }
        }

        for (int cur : cols) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][cur] = 0;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}};

        int[][] arr = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        new _073_Set_Matrix_Zeroes().setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }


}
