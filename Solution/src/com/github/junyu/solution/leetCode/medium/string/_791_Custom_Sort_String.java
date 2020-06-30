package com.github.junyu.solution.leetCode.medium.string;

public class _791_Custom_Sort_String {

    /*S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

    S was sorted in some custom order previously. We want to permute the characters of T so that
    they match the order that S was sorted. More specifically, if x occurs before y in S,
    then x should occur before y in the returned string.

    Return any permutation of T (as a string) that satisfies this property.

    Example :
    Input:
    S = "cba"
    T = "abcd"
    Output: "cbad"
    Explanation:
            "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
    Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


    Note:

    S has length at most 26, and no character is repeated in S.
    T has length at most 200.
    S and T consist of lowercase letters only.*/

    /**
     * 自定义字符串排序
     * 思路：统计T的字符出现次数，然后循环S，如果S中的当前字符在T中有出现，就将他们插入到sb中。
     * 最后将剩余的T的字符插入到sb中，题目中没有要求按T的顺序，所以直接插入尾部即可。
     * @param S
     * @param T
     * @return
     */
    public String customSortString(String S, String T) {
        int [] count = new int[26];
        for (char c :T.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<S.length();i++){
            char c = S.charAt(i);
            while (count[c-'a']>0){
                count[c-'a']--;
                sb.append(c);
            }
        }
        for (int i=0;i<T.length();i++){
            char c = T.charAt(i);
            while (count[c-'a']>0){
                count[c-'a']--;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _791_Custom_Sort_String test = new _791_Custom_Sort_String();
        System.out.println(test.customSortString("cba","abcd"));
    }
}
