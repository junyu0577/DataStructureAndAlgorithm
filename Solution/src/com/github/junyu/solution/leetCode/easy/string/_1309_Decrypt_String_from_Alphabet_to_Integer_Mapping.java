package com.github.junyu.solution.leetCode.easy.string;

public class _1309_Decrypt_String_from_Alphabet_to_Integer_Mapping {

    /*Given a string s formed by digits ('0' - '9') and '#' .
    We want to map s to English lowercase characters as follows:

    Characters ('a' to 'i') are represented by ('1' to '9') respectively.
            Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
    Return the string formed after mapping.

    It's guaranteed that a unique mapping will always exist.



    Example 1:

    Input: s = "10#11#12"
    Output: "jkab"
    Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
    Example 2:

    Input: s = "1326#"
    Output: "acz"
    Example 3:

    Input: s = "25#"
    Output: "y"
    Example 4:

    Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
    Output: "abcdefghijklmnopqrstuvwxyz"


    Constraints:

            1 <= s.length <= 1000
    s[i] only contains digits letters ('0'-'9') and '#' letter.
    s will be valid string such that mapping is always possible.
*/

    /**
     * 解码字母到整数映射
     * 思路：ASCII字符表从97开始是a,那么如果当前字符是纯数字的话，
     * 就满足['1'-'0'+96~'9'-'0'+96]等于['a'~'i']。
     * 如果发现当前字符+2索引位的字符是'#'，那么获取#之前的数字+96就是要替换的字符。
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int value = s.charAt(i)-'0';
            if (i + 2 < len && s.charAt(i + 2) == '#') {
                int num = value*10+(s.charAt(i+1)-'0');
                ans.append((char)(96+num));
                i+=2;
            } else {
               ans.append((char)(value+96));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        _1309_Decrypt_String_from_Alphabet_to_Integer_Mapping test = new _1309_Decrypt_String_from_Alphabet_to_Integer_Mapping();
        System.out.println(test.freqAlphabets("10#11#12"));
        System.out.println(test.freqAlphabets("1326#"));
        System.out.println(test.freqAlphabets("25#"));
        System.out.println(test.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));

    }
}
