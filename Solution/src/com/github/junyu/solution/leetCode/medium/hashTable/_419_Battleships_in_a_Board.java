package com.github.junyu.solution.leetCode.medium.hashTable;

public class _419_Battleships_in_a_Board {

  /*  Given an 2D board, count how many battleships are in it. The battleships are
    represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
    You receive a valid board, made of only battleships or empty slots.
    Battleships can only be placed horizontally or vertically. In other words, they
    can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
    At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
     Example:
            X..X
            ...X
            ...X
    In the above board there are 2 battleships.
    Invalid Example:
            ...X
            XXXX
            ...X
    This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
    Follow up:
    Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
*/

    private boolean marked[][];
    private int count = 0;

    /**
     * 统计甲板上战舰的数量
     * 这题与463的解法类似，不同的点在于这题探索完区域以后，仍然需要继续查看剩余二维数组中是否存在有符合条件的元素。
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        marked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && !marked[i][j]) {
                    count++;
                    findShip(i, j, board, marked);
                }
            }
        }

        return count;
    }

    private void findShip(int i, int j, char[][] board, boolean[][] marked) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] == '.') {
            return;
        }
        if (!marked[i][j]) {
            marked[i][j] = true;
            findShip(i - 1, j, board, marked);
            findShip(i + 1, j, board, marked);
            findShip(i, j - 1, board, marked);
            findShip(i, j + 1, board, marked);
        }


    }

    public static void main(String[] args) {
        _419_Battleships_in_a_Board battleships_in_a_board = new _419_Battleships_in_a_Board();
        System.out.println(battleships_in_a_board.countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {',', '.', '.', 'X'}}));
    }

}
