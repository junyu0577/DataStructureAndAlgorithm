package com.github.junyu.solution.leetCode.easy.string;

import com.github.junyu.solution.data_structure.linear.Array;

import java.util.*;

public class _893_Groups_of_Special_Equivalent_Strings {


   /* You are given an array A of strings.

    Two strings S and T are special-equivalent if after any number of moves, S == T.

    A move consists of choosing two indices i and j with i % 2 == j % 2,
    and swapping S[i] with S[j].

    Now, a group of special-equivalent strings from A is a non-empty
    subset S of A such that any string not in S is not special-equivalent with any string in S.

    Return the number of groups of special-equivalent strings from A.



    Example 1:

    Input: ["a","b","c","a","c","c"]
    Output: 3
    Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
    Example 2:

    Input: ["aa","bb","ab","ba"]
    Output: 4
    Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
    Example 3:

    Input: ["abc","acb","bac","bca","cab","cba"]
    Output: 3
    Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
    Example 4:

    Input: ["abcd","cdab","adcb","cbad"]
    Output: 1
    Explanation: 1 group ["abcd","cdab","adcb","cbad"]


    Note:

            1 <= A.length <= 1000
            1 <= A[i].length <= 20
    All A[i] have the same length.
    All A[i] consist of only lowercase letters.*/

//    /**
//     * 特殊等价字符串,如果两个字符串中部分位置（奇数位与奇数位，偶数位和偶数位）进行任意次交换后，最后两个字符串相同，
//     * 那么就判断为等价字符串。题目返回的不等价字符串的类别数量。
//     * 利用hashSet的元素唯一性，遍历A数组时，建立两个hash表分别存储奇数位和偶数位元素的数量，然后将里两个数组转为字符串拼接后，加入
//     * 到集合中。最后集合的长度就是不等价字符串的类别数量。
//     *
//     *
//     * @param A
//     * @return
//     */
//    public int numSpecialEquivGroups(String[] A) {
//        Set<String> data = new HashSet<>();
//        for (int i = 0; i < A.length; i++) {
//
//            int odd[] = new int[26];
//            int even[] = new int[26];
//            for (int j = 0; j < A[i].length(); j++) {
//                if ((j & 1) == 0) {
//                    even[A[i].charAt(j) - 'a']++;
//                } else {
//                    odd[A[i].charAt(j) - 'a']++;
//                }
//
//            }
//
//            data.add(Arrays.toString(odd) + Arrays.toString(even));
//        }
//        return data.size();
//    }


    /**
     * solution2
     * 在solution1的基础上，不再使用两个hash表，改用stringBuilder，
     * 两个sb分别统计奇偶位的字符，再利用排序将等效字符变成相同的字符串。
     *
     * @param A
     * @return
     */
    public int numSpecialEquivGroups(String[] A) {
        Set<String> data = new HashSet<>();
        for (int i = 0; i < A.length; i++) {

            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int j = 0; j < A[i].length(); j++) {

                if ((j & 1) == 0) {
                    even.append(A[i].charAt(j));
                } else {
                    odd.append(A[i].charAt(j));
                }
            }

            Arrays.sort(odd.toString().toCharArray());
            Arrays.sort(even.toString().toCharArray());

            data.add(sort(odd.toString()) + sort(even.toString()));
        }
        return data.size();
    }

    private String sort(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }

    public static void main(String[] args) {
        _893_Groups_of_Special_Equivalent_Strings groups_of_special_equivalent_strings = new _893_Groups_of_Special_Equivalent_Strings();
        System.out.println(groups_of_special_equivalent_strings.numSpecialEquivGroups(new String[]{"a", "b", "c", "a", "c", "c"}));
        System.out.println(groups_of_special_equivalent_strings.numSpecialEquivGroups(new String[]{"aa", "bb", "ab", "ba"}));
        System.out.println(groups_of_special_equivalent_strings.numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
        System.out.println(groups_of_special_equivalent_strings.numSpecialEquivGroups(new String[]{"abcd", "cdab", "adcb", "cbad"}));
    }

}
