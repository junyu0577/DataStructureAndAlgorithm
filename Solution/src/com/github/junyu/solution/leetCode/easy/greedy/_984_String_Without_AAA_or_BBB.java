package com.github.junyu.solution.leetCode.easy.greedy;

public class _984_String_Without_AAA_or_BBB {

    /*
    Given two integers A and B, return any string S such that:

    S has length A + B and contains exactly A 'a' letters,
    and exactly B 'b' letters;
    The substring 'aaa' does not occur in S;
    The substring 'bbb' does not occur in S.


            Example 1:

    Input: A = 1, B = 2
    Output: "abb"
    Explanation: "abb", "bab" and "bba" are all correct answers.
    Example 2:

    Input: A = 4, B = 1
    Output: "aabaa"


    Note:

            0 <= A <= 100
            0 <= B <= 100
    It is guaranteed such an S exists for the given A and B.
    */

    /**
     * 输出所有的a与b，单个字母连续出现的次数不能超过3次
     * 优先输出b，每次只输出一个。只有在两种情况下会输出a，一是当前已输出的末尾两个字符都是b。
     * 二是末尾的两个字符不相等，那么这种情况下只要剩余的A大于B，那么也要优先输出a。
     * @param A
     * @param B
     * @return
     */
    public String strWithout3a3b(int A, int B) {

        StringBuilder ans = new StringBuilder();
        int count = 0;
        while (A > 0 || B > 0) {
            boolean appendA = false;

            if (count >= 2 && ans.charAt(count - 2) == ans.charAt(count - 1)) {
                if (ans.charAt(count - 1) == 'b')
                    appendA = true;
            } else {
                if (A > B)
                    appendA = true;
            }

            if (appendA) {
                ans.append("a");
                A--;
            } else {
                ans.append("b");
                B--;
            }
            count++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        _984_String_Without_AAA_or_BBB string_without_aaa_or_bbb = new _984_String_Without_AAA_or_BBB();
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(1, 2));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(4, 1));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(1, 3));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(2, 5));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(2, 3));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(3, 3));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(1, 4));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(2, 4));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(4, 5));
        System.out.println(string_without_aaa_or_bbb.strWithout3a3b(4, 4));
    }
}
