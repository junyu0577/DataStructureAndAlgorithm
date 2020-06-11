package com.github.junyu.solution.leetCode.easy.math;

public class _1232_Check_If_It_Is_a_Straight_Line {

    /*You are given an array coordinates, coordinates[i] = [x, y],
    where [x, y] represents the coordinate of a point. Check if
    these points make a straight line in the XY plane.

    Example 1:

    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true
    Example 2:

    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false

    Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
            -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.
    */

    /**
     * 判断点是否在一条直线上
     * 思路：通过各点到第一个点的斜率是否相等来判断是否处在一条直线上
     * (y1-y0)/(x1-x0) = (yi-y0)/(xi-x0)
     * 由于会存在除0问题，所以将公式变换一下
     * (y1-y0)*(xi-x0) = (x1-x0)*(yi-y0)
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int x1 = coordinates[1][0];
        int y0 = coordinates[0][1];
        int y1 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            if ((y1 - y0) * (coordinates[i][0] - x0) !=
                    (coordinates[i][1] - y0) * (x1 - x0))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _1232_Check_If_It_Is_a_Straight_Line test = new _1232_Check_If_It_Is_a_Straight_Line();
        System.out.println(test.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println(test.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println(test.checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
        System.out.println(test.checkStraightLine(new int[][]{{2, 1}, {4, 2}, {6, 3}}));
    }
}
