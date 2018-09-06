package com.github.junyu.solution.leetCode.easy.others;

public class _844_Backspace_String_Compare {

   /* Given two strings S and T, return if they are equal when both are typed into empty
    text editors. # means a backspace character.

    Example 1:

    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".
    Example 2:

    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".
    Example 3:

    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".
    Example 4:

    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".
    Note:

            1 <= S.length <= 200
            1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.
    Follow up:

    Can you solve it in O(N) time and O(1) space?*/

    /**
     * 比较去除撤销后的字符串是否相同
     * 分别遍历字符串的字符，如果是#，就表示可能要删除sb中的最后一个字符，如果sb中已经没有内容了，就略过。
     * 最后比较两个新的字符串是否相等即可。
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {

        String s = getNewStr(S);
        String t = getNewStr(T);

        return s.equals(t);
    }

    private String getNewStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _844_Backspace_String_Compare().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new _844_Backspace_String_Compare().backspaceCompare("ab##", "c#d#"));
        System.out.println(new _844_Backspace_String_Compare().backspaceCompare("a##c", "#a#c"));
        System.out.println(new _844_Backspace_String_Compare().backspaceCompare("a#c", "b"));
    }

}
