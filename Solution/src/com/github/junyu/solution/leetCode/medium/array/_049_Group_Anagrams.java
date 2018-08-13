package com.github.junyu.solution.leetCode.medium.array;

import java.util.*;

public class _049_Group_Anagrams {

/*
    Given an array of strings, group anagrams together.

            Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
            [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
            ]
    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
    */

    /**
     * 将含有全部相同字母的单词存在子集合中
     * 使用一个map key为排序后的字符串，value为装有相同字母的单词集合
     * 通过遍历字符串数组，对当前的字符串转字符数组后进行排序操作，这样保证了那些顺序不一致的字母，
     * 经过排序后就得到了同一个字母。利用map键的唯一性，如果为空就创建集合然后往里添加元素，不为空说明是一个颠倒
     * 顺序的字母，并且key对应的value中已经存在有字母，直接往这个集合中添加就可以了。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null)
            return res;


        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char cs[] = strs[i].toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if (map.get(key) == null)
                map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        for (Map.Entry<String, List<String>> entries : map.entrySet()) {
            res.add(entries.getValue());
        }

        return res;

    }

    public static void main(String[] args) {
//        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String arr[] = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        _049_Group_Anagrams group_anagrams = new _049_Group_Anagrams();
        List<List<String>> list = group_anagrams.groupAnagrams(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
