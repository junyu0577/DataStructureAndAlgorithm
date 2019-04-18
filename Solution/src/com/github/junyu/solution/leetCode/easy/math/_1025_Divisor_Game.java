package com.github.junyu.solution.leetCode.easy.math;


public class _1025_Divisor_Game {

    /*
    Alice and Bob take turns playing a game, with Alice starting first.

            Initially, there is a number N on the chalkboard.  On each player's turn,
    that player makes a move consisting of:

    Choosing any x with 0 < x < N and N % x == 0.
    Replacing the number N on the chalkboard with N - x.
            Also, if a player cannot make a move, they lose the game.

    Return True if and only if Alice wins the game, assuming both players play optimally.



    Example 1:

    Input: 2
    Output: true
    Explanation: Alice chooses 1, and Bob has no more moves.
    Example 2:

    Input: 3
    Output: false
    Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.


    Note:

            1 <= N <= 1000
    */

    /**
     * Alice和Bob的回合制游戏
     * 每一轮双方都要出一个数，这个数必须在1<x<N的范围里切能被N整除，然后N-x后的结果交给对方。
     * 根据这个规则，只要保证了初始值是偶数的情况下，Alice必然获胜。
     * 如4 Alice第一轮出1，Bob面对的是3，就只能出1，到Alice为2，Alice出1，剩1，Bob就没法出了。
     * 如6 Alice出2，剩3，后同上。
     * 因此只要保证了初始值是偶数，Alice必胜。
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new _1025_Divisor_Game().divisorGame(2));
        System.out.println(new _1025_Divisor_Game().divisorGame(3));
    }
}
