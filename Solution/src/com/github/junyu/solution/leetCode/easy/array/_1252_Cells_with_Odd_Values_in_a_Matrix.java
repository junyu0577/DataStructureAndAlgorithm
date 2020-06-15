package com.github.junyu.solution.leetCode.easy.array;

public class _1252_Cells_with_Odd_Values_in_a_Matrix {

    /*Given n and m which are the dimensions of a matrix initialized by
    zeros and given an array indices where indices[i] = [ri, ci].
    For each pair of [ri, ci] you have to increment all cells in row ri
    and column ci by 1.

    Return the number of cells with odd values in the matrix after
    applying the increment to all indices.

    Example 1:

    Input: n = 2, m = 3, indices = [[0,1],[1,1]]
    Output: 6
    Explanation: Initial matrix = [[0,0,0],[0,0,0]].
    After applying first increment it becomes [[1,2,1],[0,1,0]].
    The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
    Example 2:


    Input: n = 2, m = 2, indices = [[1,1],[0,0]]
    Output: 0
    Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number
    in the final matrix.


            Constraints:

            1 <= n <= 50
            1 <= m <= 50
            1 <= indices.length <= 100
            0 <= indices[i][0] < n
            0 <= indices[i][1] < m*/

    /**
     * 奇数值单元格的数量
     * 思路：分别统计行与列的数组，奇偶判断同第一种解法。分别统计完行上的与列上的奇偶后，
     * 再同时判断下交叉时的奇偶情况，只有为一奇一偶的情况下，最终才可能是奇数。
     *
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < indices.length; i++) {
            int r = indices[i][0];
            int c = indices[i][1];
            row[r] = !row[r];
            col[c] = !col[c];

        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] && !col[j]) || (!row[i] && col[j]))
                    ans++;
            }
        }
        return ans;
    }

//    /**
//     * 奇数值单元格的数量
//     * 思路：创建n行m列的矩阵，然后根据indices二维数组对指定的行与列的单元格进行奇数与偶数的变换。
//     * 单元格默认为false，为偶数，当为true时，则此单位格为奇数。
//     * 最后判断count
//     * @param n
//     * @param m
//     * @param indices
//     * @return
//     */
//    public int oddCells(int n, int m, int[][] indices) {
//        boolean[][] arr = new boolean[n][m];
//        for (int i = 0; i < indices.length; i++) {
//            int row = indices[i][0];
//            int col = indices[i][1];
//            for (int c = 0; c < m; c++) {
//                arr[row][c] = !arr[row][c];
//            }
//            for (int r = 0; r < n; r++) {
//                arr[r][col] = !arr[r][col];
//            }
//        }
//        int ans = 0;
//        for (int i=0;i<arr.length;i++){
//            for (int j=0;j<arr[0].length;j++){
//                if (arr[i][j])
//                    ans++;
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        _1252_Cells_with_Odd_Values_in_a_Matrix test = new _1252_Cells_with_Odd_Values_in_a_Matrix();
        System.out.println(test.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        System.out.println(test.oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }
}
