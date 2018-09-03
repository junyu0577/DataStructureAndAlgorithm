package com.github.junyu.solution.leetCode.easy.array;

import java.util.Arrays;

public class _566_Reshape_the_Matrix {

   /* In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with
    different size but keep its original data.

            You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing
    the row number and column number of the wanted reshaped matrix, respectively.

    The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

    If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

    Example 1:
    Input:
    nums =
            [[1,2],
            [3,4]]
    r = 1, c = 4
    Output:
            [[1,2,3,4]]
    Explanation:
    The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
    Example 2:
    Input:
    nums =
            [[1,2],
            [3,4]]
    r = 2, c = 4
    Output:
            [[1,2],
            [3,4]]
    Explanation:
    There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
            Note:
    The height and width of the given matrix is in range [1, 100].
    The given r and c are all positive.
*/

    /**
     * 重塑矩阵，将矩阵改变为r行c列。如果无法实现r行c列，那么就返回原始矩阵。
     * 如果给定的r和c的乘积与原始的行与列乘积不一致，那么无法重塑。
     * 如果符合重塑，定义两个指针pr和pc分别指当前待插入的向行与列，当pc增长到和限定的c时，说明必须要换行了，因此pr+1，并置零pc。
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;

        if (row * col != r * c)
            return nums;


        int[][] res = new int[r][c];
        int pr = 0;
        int pc = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pc == c) {
                    pr++;
                    pc = 0;
                }
                res[pr][pc] = nums[i][j];
                pc++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2},
                {3, 4}};
        int r = 1, c = 4;
//        int r = 4, c = 1;

        int res[][] = new _566_Reshape_the_Matrix().matrixReshape(arr, r, c);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
