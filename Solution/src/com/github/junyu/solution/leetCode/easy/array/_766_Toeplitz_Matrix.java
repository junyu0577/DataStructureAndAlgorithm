package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _766_Toeplitz_Matrix {

/*
    Given a matrix A, return the transpose of A.

    The transpose of a matrix is the matrix flipped over
        it's main diagonal, switching the row and column indices of the matrix.



    Example 1:

    Input: [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[1,4,7],[2,5,8],[3,6,9]]
    Example 2:

    Input: [[1,2,3],[4,5,6]]
    Output: [[1,4],[2,5],[3,6]]


    Note:

            1 <= A.length <= 1000
            1 <= A[0].length <= 1000
    */

    /**
     * 交换矩阵的行索引与列索引
     *
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                res[i][j] = A[j][i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        _766_Toeplitz_Matrix toeplitz_matrix = new _766_Toeplitz_Matrix();
        int[][] res = toeplitz_matrix.transpose(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
