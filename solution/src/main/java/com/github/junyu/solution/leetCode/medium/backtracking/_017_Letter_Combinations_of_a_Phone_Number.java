package com.github.junyu.solution.leetCode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaoJunyu
 * @since 2018/8/3 11:45
 */
public class _017_Letter_Combinations_of_a_Phone_Number {

  /*  Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



    Example:

    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:

    Although the above answer is in lexicographical order, your answer could be in any order you want.*/


    private String letters[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 通过递归回溯,找出所有能够拼接的可能
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        findLetter(digits.toCharArray(), 0, "", result);

        return result;
    }

    private void findLetter(char[] chars, int index, String s, List<String> result) {

        if (index == chars.length) {
            result.add(s);
            return;
        }

        char num = chars[index];//获取数字
        String letterArr = letters[num - '0'];//获取数字对应的字母组
        char[] cs = letterArr.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            findLetter(chars, index + 1, s + cs[i], result);
        }
    }


    public static void main(String[] args) {
        _017_Letter_Combinations_of_a_Phone_Number letter_combinations_of_a_phone_number = new _017_Letter_Combinations_of_a_Phone_Number();
        System.out.println(letter_combinations_of_a_phone_number.letterCombinations("23"));
    }

}
