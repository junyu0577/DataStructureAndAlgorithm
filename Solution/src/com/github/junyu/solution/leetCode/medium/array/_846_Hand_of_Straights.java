package com.github.junyu.solution.leetCode.medium.array;

import java.util.Arrays;
import java.util.HashMap;

public class _846_Hand_of_Straights {

   /* Alice has a hand of cards, given as an array of integers.

    Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

            Return true if and only if she can.

    Example 1:

    Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
    Output: true
    Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
    Example 2:

    Input: hand = [1,2,3,4,5], W = 4
    Output: false
    Explanation: Alice's hand can't be rearranged into groups of 4.


    Constraints:

            1 <= hand.length <= 10000
            0 <= hand[i] <= 10^9
            1 <= W <= hand.length

   Note: This question is the same as 1296: https://leetcode
            .com/problems/divide-array-in-sets-of-k-consecutive-numbers/
            */

    /**
     * 一手顺子(划分数组为连续数字的集合)
     * 思路：先统计每个数字出现的数量，然后对数组进行排序。
     * 从升序数组中，按顺序取元素，取到一个元素时，如果他的数量大于0，那么还需要往后取K-1个数组成连续的K个数，如果在取的过程中，取不到
     * 就表示无法组成连续子数组。
     *
     * @param hand
     * @param W
     * @return
     */
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Arrays.sort(hand);
        for (int i :hand){
            int count = map.getOrDefault(i,0);
            if (count==0)
                continue;
            map.put(i,--count);
            for (int j=0;j<W-1;j++){
                count = map.getOrDefault(++i,0);
                if (count==0)
                    return false;
                map.put(i,--count);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _846_Hand_of_Straights test = new _846_Hand_of_Straights();
        System.out.println(test.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(test.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}
