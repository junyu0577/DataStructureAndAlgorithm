package com.github.junyu.solution.leetCode.easy.string;

public class _657_Judge_Route_Circle {


 /*   Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
    judge if this robot makes a circle, which means it moves back to the original place.

    The move sequence is represented by a string. And each move is represent by a character.
    The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true
    or false representing whether the robot makes a circle.

            Example 1:
    Input: "UD"
    Output: true
    Example 2:
    Input: "LL"
    Output: false*/

    /**
     * 经过上下左右移动以后，看看是否仍然在原地
     * 把空间看成一个矩阵，原点为（0，0），向上U（-1，0），向下D（1，0），向左L（0，-1），向右R（0，1）
     * 将字符串的每一个字符对应如下方向计算后，如果仍然为0就返回true
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0)
            return true;
        int row = 0;
        int col = 0;

        char cs[] = moves.toCharArray();
        for (char c : cs) {
            switch (c) {
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'R':
                    col++;
                    break;
            }
        }

        return row == 0 && col == 0;
    }

    public static void main(String[] args) {
        System.out.println(new _657_Judge_Route_Circle().judgeCircle("UD"));
        System.out.println(new _657_Judge_Route_Circle().judgeCircle("LL"));
    }

}
