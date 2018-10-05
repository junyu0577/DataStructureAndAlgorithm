package com.github.junyu.solution.leetCode.easy.hashTable;

public class _463_Island_Perimeter {

   /* You are given a map in form of a two-dimensional integer grid where 1
    represents land and 0 represents water. Grid cells are connected
        horizontally/vertically (not diagonally). The grid is completely surrounded by water,
    and there is exactly one island (i.e., one or more connected land cells).
    The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
    One cell is a square with side length 1. The grid is rectangular, width and
    height don't exceed 100. Determine the perimeter of the island.

    Example:

            [[0,1,0,0],
            [1,1,1,0],
            [0,1,0,0],
            [1,1,0,0]]

    Answer: 16
    Explanation: The perimeter is the 16 yellow stripes in the image below:*/

    private boolean marked[][];
    private int edges = 0;

    /**
     * 求岛屿的周长
     * 先通过遍历二维数组，找到第一块岛屿。后续的的所有元素不再需要遍历。
     * 以第一块岛屿为起点，向前后左右四个方法开始搜索。如果新的区域是越界或者是湖，那么直接边长+1。
     * marked数组用来标记已经访问过的区域，如果新的区域未访问过，那么继续以新的区域为起始点，向四个方法搜索。
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        marked = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    findArea(i, j, grid, marked);
                    return edges;
                }
            }
        }

        return -1;
    }

    private void findArea(int i, int j, int[][] grid, boolean[][] marked) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0) {
            edges++;
            return;
        }
        if (!marked[i][j]) {
            marked[i][j] = true;
            findArea(i - 1, j, grid, marked);
            findArea(i + 1, j, grid, marked);
            findArea(i, j - 1, grid, marked);
            findArea(i, j + 1, grid, marked);
        }


    }

    public static void main(String[] args) {
        _463_Island_Perimeter island_perimeter = new _463_Island_Perimeter();
        System.out.println(island_perimeter.islandPerimeter(new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}}));
    }


}
