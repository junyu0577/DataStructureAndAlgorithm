package com.github.junyu.solution.leetCode.easy.array;

import com.github.junyu.solution.data_structure.utils.ArrayMaker;


public class _2373_Largest_Local_Values_in_a_Matrix {

/*
    给你一个大小为 n x n 的整数矩阵 grid 。

    生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：

    maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
    换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。

    返回生成的矩阵。

             

    示例 1：



    输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
    输出：[[9,9],[8,6]]
    解释：原矩阵和生成的矩阵如上图所示。
    注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
    示例 2：



    输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
    输出：[[2,2,2],[2,2,2],[2,2,2]]
    解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
             

    提示：

    n == grid.length == grid[i].length
    3 <= n <= 100
    1 <= grid[i][j] <= 100

    */

    /**
     * 矩阵中的局部最大值
     * 创建新的数组，row和col分别减去2。遍历新数组，每遍历到一个元素时，需要同时遍历以他为中心的九宫格，并选出
     * 最大值赋值给新数组元素所在的位置。
     *
     * Runtime: 2 ms, faster than 99.88% of Java online submissions for Largest Local Values in a Matrix.
     * Memory Usage: 43.1 MB, less than 96.59% of Java online submissions for Largest Local Values in a Matrix.
     *
     * @param grid
     * @return
     */
    public int[][] largestLocal(int[][] grid) {
        int len = grid.length-2;
        int [] [] ans = new int[len][len];
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                int row = i+1;
                int col = j+1;
                int cur = 0;
                for (int m=row-1;m<=row+1;m++){
                    for (int n=col-1;n<=col+1;n++){
                        cur = Math.max(cur,grid[m][n]);
                    }
                }
                ans[i][j] = cur;
            }
        }
        return ans;
    }

    public static void main(String [] args) {
        _2373_Largest_Local_Values_in_a_Matrix test = new _2373_Largest_Local_Values_in_a_Matrix();
        int [][] array = new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        ArrayMaker.print2DArray(test.largestLocal(array));

        array = new int[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        ArrayMaker.print2DArray(test.largestLocal(array));
    }
}
