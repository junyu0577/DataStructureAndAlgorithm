package com.github.junyu.solution.leetCode.medium.array;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _950_Reveal_Cards_In_Increasing_Order {

    /*In a deck of cards, every card has a unique integer.
    You can order the deck in any order you want.

    Initially, all the cards start face down (unrevealed) in one deck.

    Now, you do the following steps repeatedly, until all cards are revealed:

    Take the top card of the deck, reveal it, and take it out of the deck.
    If there are still cards in the deck, put the next top card of the deck
    at the bottom of the deck.
    If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
    Return an ordering of the deck that would reveal the cards in increasing order.

    The first entry in the answer is considered to be the top of the deck.



            Example 1:

    Input: [17,13,11,2,3,5,7]
    Output: [2,13,3,11,5,17,7]
    Explanation:
    We get the deck in the order [17,13,11,2,3,5,7] (this
    order doesn't matter), and reorder it.
    After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
    We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
    We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
    We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
    We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
    We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
    We reveal 13, and move 17 to the bottom.  The deck is now [17].
    We reveal 17.
    Since all the cards revealed are in increasing order, the answer is correct.


    Note:

            1 <= A.length <= 1000
            1 <= A[i] <= 10^6
    A[i] != A[j] for all i != j*/

    /**
     * 对桌面上的排进行排序，使得每次按游戏规则揭牌时牌面时一个升序的过程
     * 建立一个队列，事先保存所有的索引以升序的方式。
     * 对原数组进行排序，然后对数组进行遍历，每次从队列中取出第一个元素，
     * 这个元素作为索引取到在deck中的值并添加到结果数组，
     * 如果队列还不为空，那么再取第一个元素插入到队尾。
     * 循环结束返回res
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList<>();
        int len = deck.length;
        for (int i=0;i<len;i++){
            q.add(i);
        }
        Arrays.sort(deck);
        int [] res = new int[len];
        for (int card : deck){
            res[q.poll()] = card;
            if (!q.isEmpty()){
                q.add(q.poll());
            }
        }

        return res;

    }

    public static void main(String[] args) {
        _950_Reveal_Cards_In_Increasing_Order reveal_cards_in_increasing_order = new _950_Reveal_Cards_In_Increasing_Order();
        System.out.println(Arrays.toString(reveal_cards_in_increasing_order.deckRevealedIncreasing(new int[]{3,2,1})));
        System.out.println(Arrays.toString(reveal_cards_in_increasing_order.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})));
    }
}
