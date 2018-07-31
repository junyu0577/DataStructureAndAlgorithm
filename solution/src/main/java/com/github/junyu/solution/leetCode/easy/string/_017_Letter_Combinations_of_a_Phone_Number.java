package com.github.junyu.solution.leetCode.easy.string;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaoJunyu
 * @version $Id$
 * @since 2018/7/31 21:15
 */
public class _017_Letter_Combinations_of_a_Phone_Number {

 /*   Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
    the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.

    Example:

    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:

    Although the above answer is in lexicographical order, your answer could be in any order you want.*/


    private static String letterArray[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 利用递归回溯，从一个数字出发依次递归到最后一个数字，然后回溯到上一层的分支再往下
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if ("".equals(digits))
            return res;

        combineLetters(digits.toCharArray(), 0, "", res);

        return res;
    }

    private static void combineLetters(char[] digits, int index, String s, List<String> res) {
        if (digits.length == index) {//递归到底，得到一种组合,返回上一个分支
            res.add(s);
            return;
        }

        char num = digits[index];//得到数字
        String letters = letterArray[num - '0'];//得到数字对应的字母们
        for (int i = 0; i < letters.length(); i++) {
            //递归传递另一个数字
            combineLetters(digits, index + 1, s + letters.charAt(i), res);
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

}
