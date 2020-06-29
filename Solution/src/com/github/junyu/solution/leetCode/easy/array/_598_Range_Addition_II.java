package com.github.junyu.solution.leetCode.easy.array;

public class _598_Range_Addition_II {

    /*Given an m * n matrix M initialized with all 0's and several update operations.

    Operations are represented by a 2D array, and each operation is represented by an array with
     two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

    You need to count and return the number of maximum integers in the matrix after performing all the operations.

            Example 1:
    Input:
    m = 3, n = 3
    operations = [[2,2],[3,3]]
    Output: 4
    Explanation:
    Initially, M =
            [[0, 0, 0],
            [0, 0, 0],
            [0, 0, 0]]

    After performing [2,2], M =
            [[1, 1, 0],
            [1, 1, 0],
            [0, 0, 0]]

    After performing [3,3], M =
            [[2, 2, 1],
            [2, 2, 1],
            [1, 1, 1]]

    So the maximum integer in M is 2, and there are four of it in M. So return 4.
    Note:
    The range of m and n is [1,40000].
    The range of a is [1,m], and the range of b is [1,n].
    The range of operations size won't exceed 10,000.*/

    /**
     * 范围求和
     * 思路：由于不断的在进行区域范围的叠加，那么只要找到最小的矩形区域，就可以得出最大值的个数，
     * 最小区域的面积为x*y（ops数组中最小的x与y）。
     * 当ops为空时，m*n即为最大面积。
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        int minX = Integer.MAX_VALUE;
        int minY = minX;
        for (int []ints :ops){
            minX = Math.min(minX,ints[0]);
            minY = Math.min(minY,ints[1]);
        }

        return ops.length==0?m*n:minX*minY;
    }

    public static void main(String[] args) {
        _598_Range_Addition_II test = new _598_Range_Addition_II();
        System.out.println(test.maxCount(3,3,new int[][]{{2,2},{3,3}}));
        System.out.println(test.maxCount(3,3,new int[][]{}));
    }
}
