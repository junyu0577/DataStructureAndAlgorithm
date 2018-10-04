package com.github.junyu.solution.leetCode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _784_Letter_Case_Permutation {


  /*  Given a string S, we can transform every letter individually to be
    lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

    Examples:
    Input: S = "a1b2"
    Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

    Input: S = "3z4"
    Output: ["3z4", "3Z4"]

    Input: S = "12345"
    Output: ["12345"]
    Note:

    S will be a string with length at most 12.
    S will consist only of letters or digits.*/

    /**
     * 字符串中大小写的全排列
     * 使用递归回溯的方式，结束条件为当index等于字符串的长度。
     * 不断的向下递归，并将当前的元素添加进stringBuild中，再回溯时，需要从sb中剔除。
     * 在递归的过程中会有两种可能，1是遇到数字，那么直接添加就可以。
     * 2是遇到字母，这个时候需要分别将字母的大写添加进sb，然后进行向下递归。以及将小写添加进sb，向下递归，
     * 才能获取到所有的组合。
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null)
            return res;

        letterCasePermutation(S.toCharArray(), 0, res, new StringBuilder());

        return res;
    }

    public void letterCasePermutation(char[] cs, int index, List<String> res, StringBuilder sb) {
        if (index == cs.length) {
            res.add(sb.toString());
            return;
        }

        if (cs[index] >= '0' && cs[index] <= '9') {
            sb.append(cs[index]);
            letterCasePermutation(cs, index + 1, res, sb);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(cs[index]);
            letterCasePermutation(cs, index + 1, res, sb);
            sb.deleteCharAt(sb.length()-1);
            if (cs[index] >= 'a' && cs[index] <= 'z') {
                sb.append((char) (cs[index] - 32));
                letterCasePermutation(cs, index + 1, res, sb);
            } else {
                sb.append((char) (cs[index] + 32));
                letterCasePermutation(cs, index + 1, res, sb);
            }
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new _784_Letter_Case_Permutation().letterCasePermutation("C"));
        System.out.println(new _784_Letter_Case_Permutation().letterCasePermutation("a1b2"));
        System.out.println(new _784_Letter_Case_Permutation().letterCasePermutation("3z4"));
        System.out.println(new _784_Letter_Case_Permutation().letterCasePermutation("12345"));
    }

}
