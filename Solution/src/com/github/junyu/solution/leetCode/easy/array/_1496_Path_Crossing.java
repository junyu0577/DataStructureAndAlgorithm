package com.github.junyu.solution.leetCode.easy.array;

import java.util.*;

import javafx.util.Pair;

public class _1496_Path_Crossing {

    /*Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south,
    east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
    Return True if the path crosses itself at any point, that is, if at any time you are on a location you've
    previously visited. Return False otherwise.

    Example 1:
    Input: path = "NES"
    Output: false
    Explanation: Notice that the path doesn't cross any point more than once.
    Example 2:

    Input: path = "NESWW"
    Output: true
    Explanation: Notice that the path visits the origin twice.

    Constraints:

            1 <= path.length <= 10^4
    path will only consist of characters in {'N', 'S', 'E', 'W}*/

    /**
     * 判断路径是否相交
     * 思路：记录走过的点，用pair保存坐标，存入hashSet，每走一步都判断这个点是否存在，存在就是相交。
     * 这里也可以用hashMap去存储走过得路径，key为x，value为list存储y。
     * @param path
     * @return
     */
    public boolean isPathCrossing(String path) {
        Set<Pair> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(new Pair(0,0));
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'W') {
                x--;
            } else if (path.charAt(i) == 'E') {
                x++;
            }
            Pair point = new Pair(x,y);
            if (set.contains(point))
                return true;
            set.add(point);
        }
        return false;
    }

    public static void main(String[] args) {
        _1496_Path_Crossing test = new _1496_Path_Crossing();
        System.out.println(test.isPathCrossing("NES"));
        System.out.println(test.isPathCrossing("NESWW"));
    }
}
