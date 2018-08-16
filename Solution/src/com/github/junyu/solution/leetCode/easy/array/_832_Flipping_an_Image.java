package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _832_Flipping_an_Image {

/*

    Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

    To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
    horizontally results in [0, 1, 1].

    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1]
    results in [1, 0, 0].

    Example 1:

    Input: [[1,1,0],[1,0,1],[0,0,0]]
    Output: [[1,0,0],[0,1,0],[1,1,1]]
    Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
    Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
    Example 2:

    Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
    Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    Notes:

    1 <= A.length = A[0].length <= 20
    0 <= A[i][j] <= 1
*/

    /**
     * 这题就是对二维数组中的某一行做两个操作，先翻转再取反。
     * 对于翻转操作我们进行收尾交互的方式，这里对mid为奇数的情况做特殊处理，我的循环中，如果数组的长度为奇数，那么中间的值不会遍历到，
     * 就单独对其取反。
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int mid = A[i].length / 2;
            for (int j = 0; j < mid; j++) {
                int temp = A[i][j];
                temp = temp ^ 1;
                A[i][j] = A[i][A[i].length - 1 - j] ^ 1;
                A[i][A[i].length - 1 - j] = temp;
            }
            if (A[i].length % 2 == 1)
                A[i][mid] = A[i][mid] ^ 1;
        }
        return A;
    }

    public static void main(String[] args) {
//        int arr[][] = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
//        int arr[][] = {{1}, {0}, {0,}};
        int arr[][] = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        _832_Flipping_an_Image flipping_an_image = new _832_Flipping_an_Image();
        int res[][] = flipping_an_image.flipAndInvertImage(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
