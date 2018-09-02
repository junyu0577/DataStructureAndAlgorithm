package com.github.junyu.solution.leetCode.medium.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _451_Sort_Characters_By_Frequency {

    /*Given a string, sort it in decreasing order based on the frequency of characters.

            Example 1:

    Input:
            "tree"

    Output:
            "eert"

    Explanation:
            'e' appears twice while 'r' and 't' both appear once.
            So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
            Example 2:

    Input:
            "cccaaa"

    Output:
            "cccaaa"

    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.
    Example 3:

    Input:
            "Aabb"

    Output:
            "bbAa"

    Explanation:
            "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.*/

    class Frequency {
        Character c;
        int freq;

        public  Frequency(Character c,int freq){
            this.c = c;
            this.freq = freq;
        }
    }

    /**
     * 按字符出现的频率重新排序字符串
     * 解法和347啊 378 啊类似，使用优先队列，让频率高的排前面，然后从队列中取出元素，重新组成字符串。
     * 统计词频使用hashMap
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i),1);
            }
        }

        PriorityQueue<Frequency> q = new PriorityQueue(new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                return o2.freq-o1.freq;
            }
        });

        for (Map.Entry<Character,Integer> entry :map.entrySet()){
            q.add(new Frequency(entry.getKey(),entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()){
           Frequency frequency =  q.poll();
           for (int i=0;i<frequency.freq;i++){
               sb.append(frequency.c);
           }
        }

        return sb.toString();
    }

    public static void main(String [] args) {
        System.out.println(new _451_Sort_Characters_By_Frequency().frequencySort("tree"));
        System.out.println(new _451_Sort_Characters_By_Frequency().frequencySort("cccaaa"));
        System.out.println(new _451_Sort_Characters_By_Frequency().frequencySort("Aabb"));
    }
}
