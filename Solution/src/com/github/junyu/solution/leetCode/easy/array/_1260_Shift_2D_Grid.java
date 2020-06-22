package com.github.junyu.solution.leetCode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _1260_Shift_2D_Grid {

    /*Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

    In one shift operation:

    Element at grid[i][j] moves to grid[i][j + 1].
    Element at grid[i][n - 1] moves to grid[i + 1][0].
    Element at grid[m - 1][n - 1] moves to grid[0][0].
    Return the 2D grid after applying shift operation k times.

    Example 1:

    Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
    Output: [[9,1,2],[3,4,5],[6,7,8]]
    Example 2:


    Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
    Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
    Example 3:

    Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
    Output: [[1,2,3],[4,5,6],[7,8,9]]


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m <= 50
            1 <= n <= 50
            -1000 <= grid[i][j] <= 1000
            0 <= k <= 100*/

    /**
     * 二维数组升迁
     * 思路：先将二维数组转到list中，然后对list进行k次将末尾元素插入到头部的操作。
     * 然后遍历list，将list转为二维的矩阵ans。
     *
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
        }
        while (k > 0) {
            k--;
            Integer last = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0, last);
        }

        int colMax = grid[0].length;
        int cur = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int row = i / colMax;
            if (row != cur) {
                ans.add(subList);
                subList = new ArrayList<>();
                cur = row;
            }
            subList.add(list.get(i));
        }
        ans.add(subList);
        return ans;
    }

    public static void main(String[] args) {
        _1260_Shift_2D_Grid test = new _1260_Shift_2D_Grid();
        System.out.println(test.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1));
        System.out.println(test.shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}},
                4));
        System.out.println(test.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9));
    }
}
