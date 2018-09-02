package com.github.junyu.solution.leetCode.medium.heap;

import java.util.*;

public class _692_Top_K_Frequent_Words {

   /* Given a non-empty list of words, return the k most frequent elements.

    Your answer should be sorted by frequency from highest to lowest.
    If two words have the same frequency, then the word with the lower alphabetical order comes first.

    Example 1:
    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    Output: ["i", "love"]
    Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    Example 2:
    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    Output: ["the", "is", "sunny", "day"]
    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
            Note:
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.
    Follow up:
    Try to solve it in O(n log k) time and O(n) extra space.*/

    class Frequency {
        String s;
        int freq;

        public Frequency(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }
    }

    /**
     * 前k个高频词汇
     * 还是用最小堆的解法，解法同347
     * 不过这题需要处理一点，如果词频相同，还需要比较字符串的大小，按字典序进行排列，在和第一个元素进行比较时，如果频率相同，
     * 还需要比较字典序。插入后维护队列时，比较器同样也需要按频率以及字典序进行元素的排列。
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        PriorityQueue<Frequency> q = new PriorityQueue<>(new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {

                if (o1.freq < o2.freq)
                    return -1;
                else if (o1.freq>o2.freq)
                    return 1;
                else {
                   return o2.s.compareTo(o1.s);
                }
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (q.size() < k) {
                q.add(new Frequency(entry.getKey(), entry.getValue()));
            } else if (q.peek().freq < entry.getValue() || (q.peek().freq == entry.getValue() && entry.getKey().compareTo(q.peek().s) < 0)) {
                q.poll();
                q.add(new Frequency(entry.getKey(), entry.getValue()));
            }
        }

        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(0, q.poll().s);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _692_Top_K_Frequent_Words().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new _692_Top_K_Frequent_Words().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println(new _692_Top_K_Frequent_Words().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1));
        System.out.println(new _692_Top_K_Frequent_Words().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
    }

}
