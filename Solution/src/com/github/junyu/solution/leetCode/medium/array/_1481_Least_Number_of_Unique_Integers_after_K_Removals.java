package com.github.junyu.solution.leetCode.medium.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _1481_Least_Number_of_Unique_Integers_after_K_Removals {

    /*Given an array of integers arr and an integer k. Find the least number of unique integers after removing
    exactly k elements.

    Example 1:

    Input: arr = [5,5,4], k = 1
    Output: 1
    Explanation: Remove the single 4, only 5 is left.
    Example 2:
    Input: arr = [4,3,1,1,3,3,2], k = 3
    Output: 2
    Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.

    Constraints:

            1 <= arr.length <= 10^5
            1 <= arr[i] <= 10^9
            0 <= k <= arr.length*/


    /**
     * 移除k个数后不同整数的最少数目
     * 思路：先统计数字出现的次数，然后将他们按出现次数升序插入到优先队列，然后遍历队列，移除k个元素后，剩下队列的长度即不同整数的数目。
     * 当移除后k存在小于零的情况，此时应当补回一组数目即队列长度+1.
     *
     * @param arr
     * @param k
     * @return
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.count - o2.count;
            }
        });
        for (int i : map.keySet()) {
            pq.offer(new Pair(i, map.get(i)));
        }
        while (k > 0) {
            Pair pair = pq.poll();
            k -= pair.count;
            if (k<0)
                return pq.size()+1;
        }
        return pq.size();
    }

    class Pair {
        int number;
        int count;

        public Pair(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        _1481_Least_Number_of_Unique_Integers_after_K_Removals test =
                new _1481_Least_Number_of_Unique_Integers_after_K_Removals();
        System.out.println(test.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(test.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}
