package com.github.junyu.solution.leetCode.easy.string;

import java.util.ArrayList;
import java.util.List;

public class _2194_Cells_in_a_Range_on_an_Excel_Sheet {


    /*
    A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:

    <col> denotes the column number c of the cell. It is represented by alphabetical letters.
    For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
    <row> is the row number r of the cell. The rth row is represented by the integer r.
    You are given a string s in the format "<col1><row1>:<col2><row2>", where <col1> represents the
    column c1,
    <row1> represents the row r1, <col2> represents the column c2, and <row2> represents the row r2,
    such that r1 <= r2 and c1 <= c2.

    Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2. The cells should be
    represented as strings in the format mentioned above and be sorted in non-decreasing order
    first by columns and then by rows.


    Example 1:


    Input: s = "K1:L2"
    Output: ["K1","K2","L1","L2"]
    Explanation:
    The above diagram shows the cells which should be present in the list.
    The red arrows denote the order in which the cells should be presented.

    Example 2:


    Input: s = "A1:F1"
    Output: ["A1","B1","C1","D1","E1","F1"]
    Explanation:
    The above diagram shows the cells which should be present in the list.
    The red arrow denotes the order in which the cells should be presented.


    Constraints:

    s.length == 5
            'A' <= s[0] <= s[3] <= 'Z'
            '1' <= s[1] <= s[4] <= '9'
    s consists of uppercase English letters, digits and ':'.
    */


    /**
     * Excel 表中某个范围内的单元格
     *
     * 先找出开始与结束的行与列坐标，然后如果开始的点位必结束的点位大就交换下位置。方便后续遍历与升序展示。
     * 遍历就是从列中找行
     *
     * Runtime: 8 ms, faster than 83.33% of Java online submissions for Cells in a Range on an Excel Sheet.
     * Memory Usage: 48.2 MB, less than 16.67% of Java online submissions for Cells in a Range on an Excel Sheet.
     *
     * @param s
     * @return
     */
    public List<String> cellsInRange(String s) {
        String[] sArr = s.split(":");
        char startRow = sArr[0].charAt(1);
        char endRow = sArr[1].charAt(1);

        char startCol = sArr[0].charAt(0);
        char endCol = sArr[1].charAt(0);

        if (startCol > endCol) {
            char tempChar = startCol;
            startCol = endCol;
            endCol = tempChar;
        }

        if (startRow > endRow) {
            char tempChar = startRow;
            startRow = endRow;
            endRow = tempChar;
        }
        List<String> ans = new ArrayList<>();
        for (int i = startCol - 'A'; i <= endCol - 'A'; i++) {
            for (int j = startRow - '0'; j <= endRow - '0'; j++) {
                ans.add((char) (('A' + i)) + "" + (char) (('0' + j)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _2194_Cells_in_a_Range_on_an_Excel_Sheet test = new _2194_Cells_in_a_Range_on_an_Excel_Sheet();
        System.out.println(test.cellsInRange("K1:L2"));
        System.out.println(test.cellsInRange("L2:K1"));
        System.out.println(test.cellsInRange("A1:F1"));
    }
}
