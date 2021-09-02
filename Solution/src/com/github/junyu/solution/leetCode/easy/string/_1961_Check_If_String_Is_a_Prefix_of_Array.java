package com.github.junyu.solution.leetCode.easy.string;

public class _1961_Check_If_String_Is_a_Prefix_of_Array {

/*
    Given a string s and an array of strings words, determine whether
    s is a prefix string of words.

    A string s is a prefix string of words if s can be made by concatenating
    the first k strings in words for some positive k no larger than words.length.

            Return true if s is a prefix string of words, or false otherwise.



    Example 1:

    Input: s = "iloveleetcode", words = ["i","love","leetcode","apples"]
    Output: true
    Explanation:
    s can be made by concatenating "i", "love", and "leetcode" together.
            Example 2:

    Input: s = "iloveleetcode", words = ["apples","i","love","leetcode"]
    Output: false
    Explanation:
    It is impossible to make s using a prefix of arr.


            Constraints:

            1 <= words.length <= 100
            1 <= words[i].length <= 20
            1 <= s.length <= 1000
    words[i] and s consist of only lowercase English letters.
    */

    /**
     * 检查字符串是否为数组前缀
     *
     * 定义一个指针指向字符串s的头部，然后遍历words数组，每次拿当前的元素与从字符串中截取的内容进行比较。
     * 如果数组当前元素的长度+之前的部分超过了s的长度 那么就不成立。
     * 如果当前元素与截取的内容不匹配，就不成立。
     *
     * 还有一种情况是数组的前几个元素已经完全匹配字符串，但是还有多余的元素，这种情况是成立，所以
     * 当point与s的长度相等，则条件成立。
     *
     * 最后还有一种情况是数组的元素内容少于字符串，那么可以在循环完毕后再进行一次point与s的长度判断，元素
     * 内容不足以构成s，则不成立，这个判断也可以放在最上方。
     *
     * Runtime: 1 ms, faster than 93.82% of Java online submissions for Check If String Is a Prefix of Array.
     * Memory Usage: 39.9 MB, less than 20.26% of Java online submissions for Check If String Is a Prefix of Array.
     *
     * @param s
     * @param words
     * @return
     */
    public boolean isPrefixString(String s, String[] words) {
        int point = 0;
        for (int i=0;i<words.length;i++){
            if (words[i].length()+point>s.length())//数组当前元素的长度+之前的部分超过了s的长度
                return false;

            if (!s.substring(point,point+words[i].length()).equals(words[i]))//内容不匹配
                return false;

            point+=words[i].length();

            if (point==s.length())//数组的所有元素正好与字符串相匹配
                return true;
        }

        if (point<s.length())//数组的内容无法构成s
            return false;

        return true;
    }

    public static void main(String [] args) {
        _1961_Check_If_String_Is_a_Prefix_of_Array test = new _1961_Check_If_String_Is_a_Prefix_of_Array();
        System.out.println(test.isPrefixString("iloveleetcode",new String[]{"i","love","leetcode","apples"}));
        System.out.println(test.isPrefixString("iloveleetcode",new String[]{"apples","i","love","leetcode"}));
        System.out.println(test.isPrefixString("ccccccccc",new String[]{"c","cc"}));
    }

}
