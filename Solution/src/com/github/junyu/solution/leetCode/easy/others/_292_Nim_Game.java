package com.github.junyu.solution.leetCode.easy.others;

public class _292_Nim_Game {

    /*You are playing the following Nim Game with your friend: There is a heap of stones
    on the table, each time one of you take turns to remove 1 to 3 stones. The one who
    removes the last stone will be the winner. You will take the first turn to remove the stones.


    Both of you are very clever and have optimal strategies for the game. Write a function
    to determine whether you can win the game given the number of stones in the heap.

            Example:

    Input: 4
    Output: false
    Explanation: If there are 4 stones in the heap, then you will never win the game;
    No matter 1, 2, or 3 stones you remove, the last stone will always be
    removed by your friend.*/

    /**
     * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
     * 思路：每次将石头拿1-3颗，使剩下的石头是4的倍数，这样到最后只剩下4颗时，让对手拿，无论他拿几颗都输，如果一开始的时候已经是4的倍数，那么
     * 先手的必输。
     *
     * @param n
     * @return
     */
//    public boolean canWinNim(int n) {
//        if (n<4)
//            return true;
//
//        if (n % 4 == 0) {
//            return false;
//        } else if ((n - 1) % 4 == 0)
//            return true;
//        else if ((n - 2) % 4 == 0)
//            return true;
//        else if ((n - 3) % 4 == 0)
//            return true;
//
//        return true;
//    }

    /**
     * solution2
     * 根据上一种解法，再简化一下就是只要能被4整除，我们就必输，不能被4整除，就必赢。
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }

    public static void main(String[] args) {
        _292_Nim_Game nim_game = new _292_Nim_Game();
        System.out.println(nim_game.canWinNim(4));
        System.out.println(nim_game.canWinNim(5));
        System.out.println(nim_game.canWinNim(6));
        System.out.println(nim_game.canWinNim(7));
        System.out.println(nim_game.canWinNim(8));
    }

}
