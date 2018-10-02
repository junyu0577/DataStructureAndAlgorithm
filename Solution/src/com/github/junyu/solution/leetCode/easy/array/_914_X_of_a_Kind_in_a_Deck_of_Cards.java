package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashMap;
import java.util.Map;

public class _914_X_of_a_Kind_in_a_Deck_of_Cards {


   /* In a deck of cards, each card has an integer written on it.

    Return true if and only if you can choose X >= 2 such that it
    is possible to split the entire deck into 1 or more groups of cards, where:

    Each group has exactly X cards.
    All the cards in each group have the same integer.


    Example 1:

    Input: [1,2,3,4,4,3,2,1]
    Output: true
    Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
    Example 2:

    Input: [1,1,1,2,2,2,3,3]
    Output: false
    Explanation: No possible partition.
            Example 3:

    Input: [1]
    Output: false
    Explanation: No possible partition.
            Example 4:

    Input: [1,1]
    Output: true
    Explanation: Possible partition [1,1]
    Example 5:

    Input: [1,1,2,2,2,2]
    Output: true
    Explanation: Possible partition [1,1],[2,2],[2,2]

    Note:

            1 <= deck.length <= 10000
            0 <= deck[i] < 10000*/

    /**
     * 将卡片分成两两或三三乃至kk的组合（相同数），如果的卡牌都没能被分配为同一的kk组合且没有多余的卡，返回true，反之
     * 返回false。
     * 这个问题可以拆分成两个部分，一是统计卡牌中相同数字出现的次数。这里使用hashMap进行统计。
     * 而是根据这是数字出现的次数进行求最大公约数，只要最大公约数大于1，那么说明整个卡牌组是能够
     * 被拆分为固定kk组合的。
     *
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = gcd(entry.getValue(), res);
        }


        return res > 1;

    }

    /**
     * 求最大公约数 辗转相减法
     * @param value
     * @param res
     * @return
     */
    private int gcd(Integer value, int res) {
        if (res == 0)
            return value;

        while (true) {
            if (value > res) {
                value -= res;
            } else if (value < res) {
                res -= value;
            } else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        _914_X_of_a_Kind_in_a_Deck_of_Cards x_of_a_kind_in_a_deck_of_cards = new _914_X_of_a_Kind_in_a_Deck_of_Cards();
        System.out.println(x_of_a_kind_in_a_deck_of_cards.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(x_of_a_kind_in_a_deck_of_cards.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(x_of_a_kind_in_a_deck_of_cards.hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(x_of_a_kind_in_a_deck_of_cards.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
        System.out.println(x_of_a_kind_in_a_deck_of_cards.hasGroupsSizeX(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2}));
        System.out.println(x_of_a_kind_in_a_deck_of_cards.hasGroupsSizeX(new int[]{0, 1, 1, 1, 2, 2, 3, 3, 4, 5}));
    }

}
