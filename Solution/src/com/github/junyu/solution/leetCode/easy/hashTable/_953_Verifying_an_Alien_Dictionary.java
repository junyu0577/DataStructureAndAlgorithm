package com.github.junyu.solution.leetCode.easy.hashTable;


public class _953_Verifying_an_Alien_Dictionary {

    /*In an alien language, surprisingly they also use english lowercase letters,
    but possibly in a different order. The order of the alphabet is some permutation
    of lowercase letters.

    Given a sequence of words written in the alien language, and the order of
    the alphabet, return true if and only if the given words are sorted
    lexicographicaly in this alien language.



    Example 1:

    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    Output: true
    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
            Example 2:

    Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    Output: false
    Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1],
    hence the sequence is unsorted.
            Example 3:

    Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
    Output: false
    Explanation: The first three characters "app" match, and the second string
    is shorter (in size.) According to lexicographical rules "apple" > "app",
    because 'l' > '∅', where '∅' is defined as the blank character which
    is less than any other character (More info).

    Note:

    1 <= words.length <= 100
    1 <= s1.length <= 20
    order.length == 26
    All characters in s1 and order are english lowercase letters.

    */

    /**
     * 判断数组中的元素是否符合order给定的顺序
     * 建立hash表保存每个字符的出现顺序。在后续的比较中，如果相同位置的字符，前者大多后者，则
     * 说明数组中的元素没有按照order进行排序，如果相等则继续比较后一个位置的字符。小于则进行下一个
     * 字符串的比较。注意的一点是，当两个字符串在比较中始终相等，那么最后还需要判断下两则的长度，一旦
     * 前一个元素的长度大于后者，则数组也是无效的。
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1)
            return true;

        int hash [] = new int[26];
        for (int i = 0; i < order.length(); i++) {
            hash[order.charAt(i)-'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            int p = 0;
            String s1 = words[i];
            String s2 = words[i-1];
            while (p<s1.length() && p<s2.length()){
                if (hash[s2.charAt(p)-'a']>hash[s1.charAt(p)-'a']){
                    return false;
                } else if (hash[s2.charAt(p)-'a']<hash[s1.charAt(p)-'a']){
                    break;
                }
                p++;
            }
            if (p==s1.length() && s2.length()>s1.length()){
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args) {
            _953_Verifying_an_Alien_Dictionary verifying_an_alien_dictionary = new _953_Verifying_an_Alien_Dictionary();
        System.out.println(verifying_an_alien_dictionary.isAlienSorted(new String[]{"hello","leetcode"},  "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(verifying_an_alien_dictionary.isAlienSorted(new String[]{"word","world","row"},  "worldabcefghijkmnpqstuvxyz"));
        System.out.println(verifying_an_alien_dictionary.isAlienSorted(new String[]{"apple","app"},  "abcdefghijklmnopqrstuvwxyz"));
    }
}
