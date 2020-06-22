package com.github.junyu.solution.leetCode.easy.greedy;

public class _1217_Play_with_Chips {

    /*There are some chips, and the i-th chip is at position chips[i].

    You can perform any of the two following types of moves any number of times (possibly zero) on any chip:

    Move the i-th chip by 2 units to the left or to the right with a cost of 0.
    Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
    There can be two or more chips at the same position initially.

    Return the minimum cost needed to move all the chips to the same position (any position).



    Example 1:

    Input: chips = [1,2,3]
    Output: 1
    Explanation: Second chip will be moved to positon 3 with cost 1. First chip will be moved to position 3 with cost 0.
    Total cost is 1.
    Example 2:

    Input: chips = [2,2,2,3,3]
    Output: 2
    Explanation: Both fourth and fifth chip will be moved to position two with cost 1. Total minimum cost will be 2.


    Constraints:

            1 <= chips.length <= 100
            1 <= chips[i] <= 10^9*/

    /**
     * 玩筹码，将所有筹码叠在一起最小的代价，移动1个单位，代价为1，移动两个单位代价为0
     * 思路：统计奇数位和偶数位筹码的数量，由于偶数位的移动代价为0，那么将所有的奇数位和偶数位的元素累加后，去比较奇数和偶数哪
     * 一边的数量更少，则移动更少的这一边以换取最小的代价完成任务。
     *
     * @param chips
     * @return
     */
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for (int i : chips) {
            int res = i & 1;
            if (res == 0)
                even++;
            else
                odd++;
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        _1217_Play_with_Chips test = new _1217_Play_with_Chips();
        System.out.println(test.minCostToMoveChips(new int[]{1, 2, 3}));
        System.out.println(test.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
        System.out.println(test.minCostToMoveChips(new int[]{1, 2, 2, 2, 2}));
        System.out.println(test.minCostToMoveChips(new int[]{2, 20, 9}));
    }
}
