package com.github.junyu.solution.leetCode.easy.array;

public class _766_Toeplitz_Matrix {

   /* A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

    Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


    Example 1:

    Input:
    matrix = [
            [1,2,3,4],
            [5,1,2,3],
            [9,5,1,2]
            ]
    Output: True
    Explanation:
    In the above grid, the diagonals are:
            "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
    In each diagonal all elements are the same, so the answer is True.
    Example 2:

    Input:
    matrix = [
            [1,2],
            [2,2]
            ]
    Output: False
    Explanation:
    The diagonal "[1, 2]" has different elements.

            Note:

    matrix will be a 2D array of integers.
    matrix will have a number of rows and columns in range [1, 20].
    matrix[i][j] will be integers in range [0, 99].

    Follow up:

    What if the matrix is stored on disk, and the memory is limited such that you can only load at
    most one row of the matrix into the memory at once?
    What if the matrix is so large that you can only load up a partial row into the memory at once?
    */

//    /**
//     * 查看矩阵中，左上到右下的对角线的所有元素是否相同，只要有一条对角线不相同就返回false
//     * 先扫描列，如第一列 0 0, 1 1 , 2 2，都相同再看下一行，只要遍历完第一列就可以。
//     * 扫完列再扫行，由于第一个元素已经扫后，可以直接跳过，同理，也只需要扫完第一行
//     *
//     * @param matrix
//     * @return
//     */
//    public boolean isToeplitzMatrix(int[][] matrix) {
//        for (int k = 0; k < matrix.length - 1; k++) {
//            int j = 0 + k;
//            int i = 0;
//            while (j < matrix.length - 1 && i < matrix[0].length - 1) {
//                if (matrix[j][i] != matrix[j + 1][i + 1])
//                    return false;
//                i++;
//                j++;
//            }
//        }
//
//        for (int k = 1; k < matrix[0].length - 1; k++) {
//            int j = 0;
//            int i = 0 + k;
//            while (i < matrix[0].length - 1 && j < matrix.length - 1) {
//                if (matrix[j][i] != matrix[j + 1][i + 1])
//                    return false;
//                i++;
//                j++;
//            }
//        }
//
//        return true;
//    }

    /**
     * 解法二
     * 从1 1，这个位置开始遍历，和左上角的元素做一次比较，如果不同就返回，相同就继续比较下一个元素
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix.length == 1 || matrix[0].length == 1) {//只有一列 或者一行的情况
            return true;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        int arr[][] = {{1, 2, 3, 4},
//                {5, 1, 2, 3},
//                {9, 5, 1, 2}};
        int arr[][] = {{1, 2},
                {2, 2}};

//        int arr [][] = {{18},{66}};
//        int arr[][] = {{97, 97}, {80, 97}, {10, 80}};
//        int arr[][] = {{97, 97, 97}, {80, 97, 97}};
//        int arr[][] = {{65, 98, 57}};
//        int arr[][] = {{36, 59, 71, 15, 26, 82, 87}, {56, 36, 59, 71, 15, 26, 82}, {15, 0, 36, 59, 71, 15, 26}};
        _766_Toeplitz_Matrix toeplitz_matrix = new _766_Toeplitz_Matrix();
        System.out.println(toeplitz_matrix.isToeplitzMatrix(arr));
    }
}
