package com.github.junyu.solution.leetCode.easy.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _500_Keyboard_Row {

    /*Given a List of words, return the words that can be typed using letters of alphabet on
    only one row's of American keyboard like the image below.

    American keyboard


    Example 1:
    Input: ["Hello", "Alaska", "Dad", "Peace"]
    Output: ["Alaska", "Dad"]
    Note:
    You may use one character in the keyboard more than once.
    You may assume the input string will only contain letters of alphabet.*/


    /**
     * 选出能在单行完成输入的单词
     * 定义hash表，26个字母对应的所在行。然后记录第一个字母的所在行，与后面字母的所在行进行比较，如果不同就不是同一行字母。
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0)
            return new String[0];
        List<String> res = new ArrayList<>();

        int rows[] = new int[]{2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

        for (int i = 0; i < words.length; i++) {
            char[] cs = words[i].toLowerCase().toCharArray();
            int row = 1;
            for (int j = 0; j < cs.length; j++) {
                if (j == 0)
                    row = rows[cs[j] - 'a'];
                else if (row != rows[cs[j] - 'a'])
                    break;
                if (j == cs.length - 1)
                    res.add(words[i]);
            }
        }

        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _500_Keyboard_Row().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(new _500_Keyboard_Row().findWords(new String[]{"a", "b"})));
    }
}
