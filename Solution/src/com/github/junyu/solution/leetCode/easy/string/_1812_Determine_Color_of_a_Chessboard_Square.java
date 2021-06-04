package com.github.junyu.solution.leetCode.easy.string;

public class _1812_Determine_Color_of_a_Chessboard_Square {

    /*
    Example 1:

    Input: coordinates = "a1"
    Output: false
    Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
    Example 2:

    Input: coordinates = "h3"
    Output: true
    Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
    Example 3:

    Input: coordinates = "c7"
    Output: false


    Constraints:

    coordinates.length == 2
            'a' <= coordinates[0] <= 'h'
            '1' <= coordinates[1] <= '8'
*/


    /**
     * 判断国际象棋棋盘中一个格子的颜色
     *
     * 记录第一行的格子颜色，然后列的话，只要是奇数列，颜色就与第一行同列的格子相同
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Determine Color of a Chessboard Square.
     * Memory Usage: 36.8 MB, less than 80.21% of Java online submissions for Determine Color of a Chessboard Square.
     *
     * @param coordinates
     * @return
     */
    public boolean squareIsWhite(String coordinates) {
        boolean [] hash = new boolean[]{false,true,false,true,false,true,false,true};
        boolean ans = hash[coordinates.charAt(0)-'a'];
        int row = coordinates.charAt(1)-'0';
        return (row%2!=0)==ans;
    }

    public static void main(String[] args) {
        _1812_Determine_Color_of_a_Chessboard_Square test = new _1812_Determine_Color_of_a_Chessboard_Square();
        System.out.println(test.squareIsWhite("a1"));
        System.out.println(test.squareIsWhite("h3"));
        System.out.println(test.squareIsWhite("c7"));
    }
}
