package com.github.junyu.solution.leetCode.easy.string;

public class _058_Length_of_Last_Word {



  /*  Given a string s consists of upper/lower-case alphabets and
    empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

            Example:

    Input: "Hello World"
    Output: 5*/

    /**
     * 最后一个单词的长度
     * 使用split分割空格，直接求数组中最后一个元素的长度
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        if (s.trim().length() == 0)
            return 0;

        String ss[] = s.split(" ");
        return ss[ss.length - 1].length();

    }

    public static void main(String[] args) {
        _058_Length_of_Last_Word length_of_last_word = new _058_Length_of_Last_Word();
        System.out.println(length_of_last_word.lengthOfLastWord("Hello World"));
        System.out.println(length_of_last_word.lengthOfLastWord(" "));
    }

}
