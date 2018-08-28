package com.github.junyu.solution.leetCode.easy.array;

public class _695_Max_Area_of_Island {


  /*  Given a non-empty 2D array grid of 0's and 1's, an island is a group of
        1's (representing land) connected 4-directionally (horizontal or vertical.)
    You may assume all four edges of the grid are surrounded by water.

    Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

    Example 1:
            [[0,0,1,0,0,0,0,1,0,0,0,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,1,1,0,1,0,0,0,0,0,0,0,0],
            [0,1,0,0,1,1,0,0,1,0,1,0,0],
            [0,1,0,0,1,1,0,0,1,1,1,0,0],
            [0,0,0,0,0,0,0,0,0,0,1,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
            Example 2:
            [[0,0,0,0,0,0,0,0]]
    Given the above grid, return 0.
    Note: The length of each dimension in the given grid does not exceed 50.*/

    private int tempCount = 0;

    /**
     * 求岛屿的最大面积,也就是求矩阵中1与1相连的最大数量（只考虑上下左右）
     * 从头到尾遍历二维数组，当元素为1时，已他为中心向4个方向进行探索，递归的结果条件就是不能超出矩阵的范围和新的区域
     * 不能为0，每探索完一个区域后，将其赋值为0，这样在以后遇到同一个位置时，不会进行重复的探索。
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int size = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    tempCount = 0;
                    findPath(i, j, grid, grid.length, grid[0].length);
                    size = Math.max(size, tempCount);
                }
            }
        }
        return size;
    }

    private void findPath(int i, int j, int[][] grid, int rows, int cols) {
        if (i >= rows || i < 0 || j < 0 || j >= cols || grid[i][j] == 0)
            return;

        tempCount++;

        grid[i][j] = 0;

        findPath(i - 1, j, grid, rows, cols);
        findPath(i + 1, j, grid, rows, cols);
        findPath(i, j - 1, grid, rows, cols);
        findPath(i, j + 1, grid, rows, cols);

    }

    public static void main(String[] args) {
        int arr[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(new _695_Max_Area_of_Island().maxAreaOfIsland(arr));
    }

}
