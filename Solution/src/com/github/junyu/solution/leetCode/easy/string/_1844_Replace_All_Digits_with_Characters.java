package com.github.junyu.solution.leetCode.easy.string;

public class _1844_Replace_All_Digits_with_Characters {

/*
    You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.

    There is a function shift(c, x), where c is a character and x is a digit, that returns the xth character after c.

    For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
    For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).

    Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.

    Example 1:

    Input: s = "a1c1e1"
    Output: "abcdef"
    Explanation: The digits are replaced as follows:
            - s[1] -> shift('a',1) = 'b'
            - s[3] -> shift('c',1) = 'd'
            - s[5] -> shift('e',1) = 'f'


    Example 2:

    Input: s = "a1b2c3d4e"
    Output: "abbdcfdhe"
    Explanation: The digits are replaced as follows:
            - s[1] -> shift('a',1) = 'b'
            - s[3] -> shift('b',2) = 'd'
            - s[5] -> shift('c',3) = 'f'
            - s[7] -> shift('d',4) = 'h'


    Constraints:

            1 <= s.length <= 100
    s consists only of lowercase English letters and digits.
            shift(s[i-1], s[i]) <= 'z' for all odd indices i.
    */


    /**
     * 将所有数字用字符替换
     * 从索引1开始，遍历奇数位，将当前位置的字符替换为前一个位置的字符与当前位置数字的偏移（'a'+1='b'）
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Replace All Digits with Characters.
     * Memory Usage: 37.3 MB, less than 57.12% of Java online submissions for Replace All Digits with Characters.
     *
     * @param s
     * @return
     */
    public String replaceDigits(String s) {
        char [] cs = s.toCharArray();
        for (int i=1;i<s.length();i+=2){
            cs[i] = (char)(cs[i-1]+(cs[i]-'0'));
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        _1844_Replace_All_Digits_with_Characters test = new _1844_Replace_All_Digits_with_Characters();
        System.out.println(test.replaceDigits("a1c1e1"));
        System.out.println(test.replaceDigits("a1b2c3d4e"));
    }
}
