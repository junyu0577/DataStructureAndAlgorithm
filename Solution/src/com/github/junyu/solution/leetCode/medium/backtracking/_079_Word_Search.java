package com.github.junyu.solution.leetCode.medium.backtracking;

public class _079_Word_Search {

   /*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell,
    where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

            Example:

    board =
            [
            ['A','B','C','E'],
            ['S','F','C','S'],
            ['A','D','E','E']
            ]

    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
*/

    private boolean[][] visited;
    private int width, height;
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//对应上右下左四个方向

    /**
     * 在二维数组中查找字符串，二维数组对应的每一步会有四个方向，
     * 在递归的过程中，如果匹配上一个字符串就继续递归，向该字符串的四个方向进行查找，由于每次字母只能被使用依次，
     * 就需要定义一个visited二维数组进行记录已经访问的字母，当然，在回溯的过程中，需要重置对应字母的访问状态
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        if (board == null)
            return false;

        height = board.length;
        width = board[0].length;
        visited = new boolean[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchBoard(board, word, 0, i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean searchBoard(char[][] board, String word, int index, int x, int y) {

        if (index == word.length() - 1) {
            return word.charAt(index) == board[x][y];
        }

        if (word.charAt(index) == board[x][y]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (isInArea(newX, newY) && !visited[newX][newY] && searchBoard(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }

        return false;
    }

    private boolean isInArea(int newX, int newY) {
        return newX >= 0 && newX < height && newY >= 0 && newY < width;
    }

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        _079_Word_Search word_search = new _079_Word_Search();
        System.out.println(word_search.exist(board, "ABCC"));
        System.out.println(word_search.exist(board, "ABC"));
        System.out.println(word_search.exist(board, "A"));
        System.out.println(word_search.exist(board, "ABD"));
        System.out.println(word_search.exist(board, "ESEC"));
        System.out.println(word_search.exist(board, "ESECC"));
        System.out.println(word_search.exist(board, "ESECE"));

    }


}
