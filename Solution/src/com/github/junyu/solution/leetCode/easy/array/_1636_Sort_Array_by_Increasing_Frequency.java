package com.github.junyu.solution.leetCode.easy.array;

import java.util.*;

public class _1636_Sort_Array_by_Increasing_Frequency {

   /*
    Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
    If multiple values have the same frequency, sort them in decreasing order.

    Return the sorted array.

    Example 1:

    Input: nums = [1,1,2,2,2,3]
    Output: [3,1,1,2,2,2]
    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
    Example 2:

    Input: nums = [2,3,1,3,2]
    Output: [1,3,3,2,2]
    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

    Example 3:

    Input: nums = [-1,1,-6,4,5,-6,1,4,1]
    Output: [5,-1,4,4,-6,-6,1,1,1]


    Constraints:

            1 <= nums.length <= 100
            -100 <= nums[i] <= 100
   */

    public class Freq {
        private int num;
        private int count;

        public Freq(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    /**
     * 按照频率将数组升序排序（给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序）
     * 建立hash表用来统计-100~100之间数字出现的次数，然后遍历hash表讲数量超过1个的添加到优先队列中，优先队列的比较器判断当数量相等时，对数值本身进行降序，其余情况
     * 升序。
     * 最后从队列中依次取出元素并加入到结果数组中。
     *
     * Runtime: 3 ms, faster than 97.56% of Java online submissions for Sort Array by Increasing Frequency.
     * Memory Usage: 39.1 MB, less than 49.97% of Java online submissions for Sort Array by Increasing Frequency.
     *
     * @param nums
     * @return
     */
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 100]++;
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                if (o1.count == o2.count) {
                    return o2.num - o1.num;
                } else {
                    return o1.count - o2.count;
                }
            }
        });

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                pq.add(new Freq(i - 100, count[i]));
            }
        }

        int[] ans = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            Freq freq = pq.poll();
            int cur = 0;
            while (cur < freq.count) {
                ans[index] = freq.num;
                index++;
                cur++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _1636_Sort_Array_by_Increasing_Frequency test = new _1636_Sort_Array_by_Increasing_Frequency();
        System.out.println(Arrays.toString(test.frequencySort(new int[]{1,1,2,2,2,3})));
        System.out.println(Arrays.toString(test.frequencySort(new int[]{2,3,1,3,2})));
        System.out.println(Arrays.toString(test.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }
}
