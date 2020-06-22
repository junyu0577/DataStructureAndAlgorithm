package com.github.junyu.solution.leetCode.easy.array;

public class _892_Surface_Area_of_3D_Shapes {

    /*On a N * N grid, we place some 1 * 1 * 1 cubes.

    Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

    Return the total surface area of the resulting shapes.



    Example 1:

    Input: [[2]]
    Output: 10
    Example 2:

    Input: [[1,2],[3,4]]
    Output: 34
    Example 3:

    Input: [[1,0],[0,2]]
    Output: 16
    Example 4:

    Input: [[1,1,1],[1,0,1],[1,1,1]]
    Output: 32
    Example 5:

    Input: [[2,2,2],[2,1,2],[2,2,2]]
    Output: 46


    Note:

            1 <= N <= 50
            0 <= grid[i][j] <= 50*/

    /**
     * 求堆叠物体的表面积
     * 思路：先挨个求得一个元素区域所堆叠的表面积，同时判断上方与右方师是否有接触，如果有接触，需要减掉接触面。
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==0)
                    continue;

                ans += (1 + 2 * grid[i][j]) * 2;
                if (i > 0) {
                    ans -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if (j > 0) {
                    ans -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _892_Surface_Area_of_3D_Shapes test = new _892_Surface_Area_of_3D_Shapes();
        System.out.println(test.surfaceArea(new int[][]{{2}}));
        System.out.println(test.surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(test.surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        System.out.println(test.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
