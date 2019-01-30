package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.HashMap;

public class _205_Isomorphic_Strings {

   /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with
    another character while preserving the order of characters.
    No two characters may map to the same character but a character may map to itself.

    Example 1:

    Input: s = "egg", t = "add"
    Output: true
    Example 2:

    Input: s = "foo", t = "bar"
    Output: false
    Example 3:

    Input: s = "paper", t = "title"
    Output: true
    Note:
    You may assume both s and t have the same length.
*/

    /**
     * 判断两个字符串是否是同构的
     * 通过比较map的put方法返回的返回值进行判断，map的put返回值会返回上一次添加的key对应的
     * value，如果之前没有添加过则会返回null。
     * 以egg和add为例
     * 首次分别往m1和m2添加e和a时，因为之前没有添加过e和a，那么put方法会分别返回null。
     * 添加g和d时，同上。
     * 再次添加g和d时，由于上一次添加过，那么返回上一次的value，也就是1。
     * 所以只要两个map的put返回值返回的不相等，那么就是同构的。
     * 要注意的是==比较的是地址值，所以我们在插入时需要插入Integer，否则在超过-128～127
     * 的范围后为造成由于地址值不一致而值相等时造成的不想等问题。
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for (Integer i = 0; i < s.length(); i++) {
            if (m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i))
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        _205_Isomorphic_Strings isomorphic_strings = new _205_Isomorphic_Strings();
        System.out.println(isomorphic_strings.isIsomorphic("egg", "add"));
        System.out.println(isomorphic_strings.isIsomorphic("foo", "bar"));
        System.out.println(isomorphic_strings.isIsomorphic("paper", "title"));
        System.out.println(isomorphic_strings.isIsomorphic("abad", "cdcd"));
    }
}
