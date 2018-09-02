package com.github.junyu.solution.leetCode.medium.heap;


import java.util.*;

public class _347_Top_K_Frequent_Elements {


  /*  Given a non-empty array of integers, return the k most frequent elements.

            Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    Example 2:

    Input: nums = [1], k = 1
    Output: [1]
    Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

    class Frequent {
        private int e;
        private int freq;

        public Frequent(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    /**
     * 找出出现频率为前k的数
     * 利用优先队列求解，先统计nums中各个数的出现频率，可以用treeMap实现，然后迭代treeMap，往优先队列中插入，
     * 优先队列的长度就定为k，里面保存出现频率最高的元素，也就是最小堆，第一个元素的值是这个队列中最小的，当队中与阿苏怒
     * 的数量达到k后，后续的元素插入时，就需要和第一个元素进行比较，如果大于，就删除第一个元素，并将当前的元素插入到队列中
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Frequent> q = new PriorityQueue<>(new Comparator<Frequent>() {
            @Override
            public int compare(Frequent o1, Frequent o2) {
                return o1.freq - o2.freq;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (q.size() < k) {
                q.add(new Frequent(entry.getKey(), entry.getValue()));
            } else if (q.peek().freq < entry.getValue()) {
                q.poll();
                q.add(new Frequent(entry.getKey(), entry.getValue()));
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Frequent f : q) {
            res.add(f.e);
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 3};
        int k = 2;

//        int arr[] = { 2,2,3,1,1,1,4,4,4,4,5,5,5,5,5};
//        int k = 3;

//        int arr[] = {1};
//        int k = 1;

        System.out.println(new _347_Top_K_Frequent_Elements().topKFrequent(arr, k));

    }

}
