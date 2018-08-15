package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.*;

public class _884_Uncommon_Words_from_Two_Sentences {

/*
    We are given two sentences A and B.  (A sentence is a string
    of space separated words.  Each word consists only of lowercase letters.)

    A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

    Return a list of all uncommon words.

    You may return the list in any order.



            Example 1:

    Input: A = "this apple is sweet", B = "this apple is sour"
    Output: ["sweet","sour"]
    Example 2:

    Input: A = "apple apple", B = "banana"
    Output: ["banana"]


    Note:

            0 <= A.length <= 200
            0 <= B.length <= 200
    A and B both contain only spaces and lowercase letters.
    */

    /**
     * 找到在A和B中只出现过1次的单词
     * 首先用空格分别将A和B转换成数组，分别遍历数组并将单词加入hashmap，key为单词，value为出现的次数。
     * 最后迭代map，将只出现过一次的单词添加到list中，list转换为array
     *
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String,Integer> map = new HashMap<>();
        addToMap(A,map);
        addToMap(B,map);
        List<String> words = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue()==1){
                words.add(entry.getKey());
            }
        }
        return words.toArray(new String[words.size()]);

    }

    private void addToMap(String s, HashMap<String,Integer> map) {
        if (s != null && s.length() > 0) {
            String as[] = s.split(" ");
            for (int i = 0; i < as.length; i++) {
                if (map.get(as[i])==null)
                    map.put(as[i],1);
                else
                    map.put(as[i],map.get(as[i])+1);
            }
        }
    }

    public static void main(String[] args) {
        String A = "this apple is sweet", B = "this apple is sour";
//        String A = "apple apple", B = "banana";
        _884_Uncommon_Words_from_Two_Sentences uncommon_words_from_two_sentences = new _884_Uncommon_Words_from_Two_Sentences();
        System.out.println(Arrays.toString(uncommon_words_from_two_sentences.uncommonFromSentences(A,B)));
    }
}
