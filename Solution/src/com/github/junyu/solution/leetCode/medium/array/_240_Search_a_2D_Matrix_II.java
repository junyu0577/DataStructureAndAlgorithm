package com.github.junyu.solution.leetCode.medium.array;

public class _240_Search_a_2D_Matrix_II {

    /*Write an efficient algorithm that searches for a value in an m x n matrix.
    This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
    Example:

    Consider the following matrix:

            [
            [1,   4,  7, 11, 15],
            [2,   5,  8, 12, 19],
            [3,   6,  9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30]
            ]
    Given target = 5, return true.

    Given target = 20, return false.*/

    /**
     * 074的进阶版，区别在于在这个二维数组中，元素直接的排列不是整体升序的。但是保证了每一行所有的元素是升序，每一列也如此。
     * 根据这个升序的规则，我们可以以右上角的元素为出发点，拿他与target进行比较，如果比target小，那只需要往下查找就行了（row++），因为只有这一列的
     * 元素才可能大于target。如果大于target，那么就直接排除掉了当前列，往前一列进行比较（col--）。如果越过边界，那么就表示target不存在于二维数组。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        _240_Search_a_2D_Matrix_II search_a_2D_matrix_ii = new _240_Search_a_2D_Matrix_II();
        System.out.println(search_a_2D_matrix_ii.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(search_a_2D_matrix_ii.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
    }

}
