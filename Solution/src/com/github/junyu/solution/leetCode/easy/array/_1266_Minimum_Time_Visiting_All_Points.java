package com.github.junyu.solution.leetCode.easy.array;

public class _1266_Minimum_Time_Visiting_All_Points {

    /*On a plane there are n points with integer coordinates points[i] =
            [xi, yi]. Your task is to find the minimum time in seconds to visit all points.

    You can move according to the next rules:

    In one second always you can either move vertically, horizontally by one unit or
    diagonally (it means to move one unit vertically and one unit horizontally in one second).
    You have to visit the points in the same order as they appear in the array.


    Example 1:

    Input: points = [[1,1],[3,4],[-1,0]]
    Output: 7
    Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] ->
        [1,2] -> [0,1] -> [-1,0]
    Time from [1,1] to [3,4] = 3 seconds
    Time from [3,4] to [-1,0] = 4 seconds
    Total time = 7 seconds
    Example 2:

    Input: points = [[3,2],[-2,2]]
    Output: 5


    Constraints:

    points.length == n
    1 <= n <= 100
    points[i].length == 2
            -1000 <= points[i][0], points[i][1] <= 1000*/


    /**
     * 访问到各个点的最短距离
     * 思路:两点之间，末尾的X坐标与起始点的X坐标和末尾Y与起始Y，谁的距离更大，那就需要移动该距离之差的绝对值。
     * 注意，每次计算后，还需要更新起始坐标。
     * @param points
     * @return
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int startX = points[0][0];
        int startY = points[0][1];
        int step = 0;
        for (int i = 1; i < points.length; i++) {
            int endX = points[i][0];
            int endY = points[i][1];
            step+=Math.max(Math.abs(endX-startX), Math.abs(endY-startY));
            startX = endX;
            startY = endY;
        }
        return step;
    }

    public static void main(String[] args) {
        _1266_Minimum_Time_Visiting_All_Points test = new _1266_Minimum_Time_Visiting_All_Points();
        System.out.println(test.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
        System.out.println(test.minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
    }
}
