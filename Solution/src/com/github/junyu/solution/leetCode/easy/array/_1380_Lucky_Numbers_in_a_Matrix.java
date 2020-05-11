package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _1380_Lucky_Numbers_in_a_Matrix {

    /*Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

    A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

    Example 1:

    Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
    Output: [15]
    Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
    Example 2:

    Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
    Output: [12]
    Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
            Example 3:

    Input: matrix = [[7,8],[1,2]]
    Output: [7]


    Constraints:

    m == mat.length
    n == mat[i].length
    1 <= n, m <= 50
    1 <= matrix[i][j] <= 10^5.
    All elements in the matrix are distinct.*/

    /**
     * 获取矩阵中的幸运数字（行里最小值，列中最大值）
     * 思路：遍历矩阵，先从行中找出最小值，然后用最小值再在列中进行最大值的比较，如果行中的最小值是列中的最大值，那么返回true。当前索引位置的值
     * 即是幸运数。
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int rowMinNumber = matrix[i][0];
            int curColumnIndex = 0;
            for (int j = curColumnIndex + 1; j < matrix[i].length; j++) {
                if (rowMinNumber > matrix[i][j]) {
                    rowMinNumber = matrix[i][j];
                    curColumnIndex = j;
                }
            }

            boolean isLuckyValue = checkColumnMax(matrix, curColumnIndex, rowMinNumber);
            if (isLuckyValue) {
                List<Integer> ans = new ArrayList<>();
                ans.add(rowMinNumber);
                return ans;
            }

        }
        return new ArrayList<>();
    }

    private boolean checkColumnMax(int[][] matrix, int columnIndex, int rowMinNumber) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][columnIndex] > rowMinNumber) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _1380_Lucky_Numbers_in_a_Matrix test = new _1380_Lucky_Numbers_in_a_Matrix();
        System.out.println(test.luckyNumbers(new int[][]{{7,8}}));
        System.out.println(test.luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));
        System.out.println(test.luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
        System.out.println(test.luckyNumbers(new int[][]{{7,8},{1,2}}));
        System.out.println(test.luckyNumbers(new int[][]{{36376,85652,21002,4510},{68246,64237,42962,9974},{32768,
        97721,47338,5841},{55103,18179,79062,46542}}));
        System.out.println(test.luckyNumbers(new int[][]{{37175, 88469, 34383, 59878}, {22895, 89898, 39729, 86750},
                {47526, 17430, 59891, 31377}, {57626, 80390, 49184, 5802}}));
    }
}
