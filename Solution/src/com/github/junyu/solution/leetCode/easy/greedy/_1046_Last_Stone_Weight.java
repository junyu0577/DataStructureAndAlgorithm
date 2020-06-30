package com.github.junyu.solution.leetCode.easy.greedy;

import java.util.*;

public class _1046_Last_Stone_Weight {

    /*We have a collection of stones, each stone has a positive integer weight.

    Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights
    x and y with x <= y.  The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
    At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



    Example 1:

    Input: [2,7,4,1,8,1]
    Output: 1
    Explanation:
    We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
    we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
    we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
    we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


    Note:

            1 <= stones.length <= 30
            1 <= stones[i] <= 1000*/

    /**
     * 最后一块石头的重量
     * 思路：将元素按降序加入到优先队列，不断从队列中poll元素，直到队列的元素不足两个。
     * 当poll出来的第一个元素大于第二个元素，那么将他们的差插入到队列中。
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i=stones.length-1;i>=0;i--){
            pq.offer(stones[i]);
        }
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            int res = a-b;
            if (res>0)
                pq.offer(res);
        }
        return pq.size()==0?0:pq.poll();
    }

    public static void main(String[] args) {
        _1046_Last_Stone_Weight test = new _1046_Last_Stone_Weight();
        System.out.println(test.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
