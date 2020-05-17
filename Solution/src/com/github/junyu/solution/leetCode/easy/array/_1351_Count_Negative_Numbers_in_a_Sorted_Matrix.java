package com.github.junyu.solution.leetCode.easy.array;

public class _1351_Count_Negative_Numbers_in_a_Sorted_Matrix {


/*    Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.

    Return the number of negative numbers in grid.

    Example 1:

    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    Output: 8
    Explanation: There are 8 negatives number in the matrix.
            Example 2:

    Input: grid = [[3,2],[1,0]]
    Output: 0
    Example 3:

    Input: grid = [[1,-1],[-1,-1]]
    Output: 3
    Example 4:

    Input: grid = [[-1]]
    Output: 1


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
            -100 <= grid[i][j] <= 100*/


    /**
     * 找出降序矩阵中负数的数量
     * 遍历矩阵，当遇到负数时，说明当前行中的后续元素都为负数，如果行首元素为负数，
     * 那么说明后续无论是行还是列，所有的元素都为负数。
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    if (j==0){//行首元素为负数，直接统计剩余元素的数量
                        count += (grid[i].length-j) +(grid.length-1-i)*grid[i].length;
                        return count;
                    }
                    count += (grid[i].length-j);//统计当前行剩余的元素
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        _1351_Count_Negative_Numbers_in_a_Sorted_Matrix test = new _1351_Count_Negative_Numbers_in_a_Sorted_Matrix();
        System.out.println(test.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2,
                -3}}));
        System.out.println(test.countNegatives(new int[][]{{3, 2}, {1, 0}}));
        System.out.println(test.countNegatives(new int[][]{{1, -1}, {-1, -1}}));
        System.out.println(test.countNegatives(new int[][]{{-1}}));
    }
}
