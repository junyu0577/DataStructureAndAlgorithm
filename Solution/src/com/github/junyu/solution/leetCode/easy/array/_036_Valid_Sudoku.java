package com.github.junyu.solution.leetCode.easy.array;


import java.util.Arrays;

/**
 * @author ShaoJunyu
 * @since 2018/7/31 10:30
 */
public class _036_Valid_Sudoku {


    /*Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

    Example 1:

    Input:
            [
            ['5','3','.','.','7','.','.','.','.'],
            ['6','.','.','1','9','5','.','.','.'],
            ['.','9','8','.','.','.','.','6','.'],
            ['8','.','.','.','6','.','.','.','3'],
            ['4','.','.','8','.','3','.','.','1'],
            ['7','.','.','.','2','.','.','.','6'],
            ['.','6','.','.','.','.','2','8','.'],
            ['.','.','.','4','1','9','.','.','5'],
            ['.','.','.','.','8','.','.','7','9']
            ]
    Output: true
    Example 2:

    Input:
            [
            ['8','3','.','.','7','.','.','.','.'],
            ['6','.','.','1','9','5','.','.','.'],
            ['.','9','8','.','.','.','.','6','.'],
            ['8','.','.','.','6','.','.','.','3'],
            ['4','.','.','8','.','3','.','.','1'],
            ['7','.','.','.','2','.','.','.','6'],
            ['.','6','.','.','.','.','2','8','.'],
            ['.','.','.','4','1','9','.','.','5'],
            ['.','.','.','.','8','.','.','7','9']
            ]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.*/


    /**
     * 保证每一行，每一列，每一个9宫格都不包含重复元素
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {

        boolean marked[] = new boolean[9];
        for (int i = 0; i < board.length; i++) {//检查行
            Arrays.fill(marked, false);
            for (int j = 0; j < board.length; j++) {
                if (!isValid(marked, board[i][j]))
                    return false;
            }
        }

        for (int i = 0; i < board.length; i++) {//检查列
            Arrays.fill(marked, false);
            for (int j = 0; j < board.length; j++) {
                if (!isValid(marked, board[j][i]))
                    return false;
            }
        }

        for (int i = 0; i < board.length; i += 3) {//检查九宫格
            for (int j = 0; j < board.length; j += 3) {//控制循环的起始点
                Arrays.fill(marked,false);
                for (int pass=0;pass<board.length;pass++){//依次遍历九宫格里的每一个数 需要动态加上起始点i和j
                    if (!isValid(marked,board[pass/3+i][pass%3+j]))
                        return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(boolean[] marked, char c) {
        if (c == '.')
            return true;

        if (marked[c - '0' - 1])
            return false;
        else
            marked[c - '0' - 1] = true;

        return true;
    }

    public static void main(String[] args) {
        char arr[][] = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '5', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(arr));
    }
}
