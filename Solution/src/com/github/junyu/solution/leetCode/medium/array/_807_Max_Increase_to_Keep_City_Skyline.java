package com.github.junyu.solution.leetCode.medium.array;

public class _807_Max_Increase_to_Keep_City_Skyline {

    /*In a 2 dimensional array grid, each value grid[i][j] represents the height
    of a building located there. We are allowed to increase the height of any
    number of buildings, by any amount (the amounts can be different for
            different buildings). Height 0 is considered to be a building as well.

    At the end, the "skyline" when viewed from all four directions of the grid,
    i.e. top, bottom, left, and right, must be the same as the skyline of
    the original grid. A city's skyline is the outer contour of the rectangles
    formed by all the buildings when viewed from a distance. See the following example.

    What is the maximum total sum that the height of the buildings can be increased?

    Example:
    Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    Output: 35
    Explanation:
    The grid is:
            [[3, 0, 8, 4],
            [2, 4, 5, 7],
            [9, 2, 6, 3],
            [0, 3, 1, 0] ]

    The skyline viewed from top or bottom is: [9, 4, 8, 7]
    The skyline viewed from left or right is: [8, 7, 9, 3]

    The grid after increasing the height of buildings without affecting skylines is:

    gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]

    Notes:

            1 < grid.length = grid[0].length <= 50.
    All heights grid[i][j] are in the range [0, 100].
    All buildings in grid[i][j] occupy the entire grid cell: that is,
    they are a 1 x 1 x grid[i][j] rectangular prism.*/

    /**
     * 保持天际线
     * 思路：统计出每行每列的最大值，然后遍历矩阵，每个元素只能增加到行最大值与列最大值的中较小的那一个。
     * 次大值与当前元素的差值如果大于0，说明元素需要增加到次大值的大小，这时需要将差值累加到sum。
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++)
                max = Math.max(max, grid[i][j]);
            rowMax[i]=max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++)
                max = Math.max(max, grid[j][i]);
            colMax[i]=max;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int min = Math.min(rowMax[i], colMax[j]) - grid[i][j];
                if (min > 0)
                    sum += min;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _807_Max_Increase_to_Keep_City_Skyline test = new _807_Max_Increase_to_Keep_City_Skyline();
        System.out.println(test.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }
}
