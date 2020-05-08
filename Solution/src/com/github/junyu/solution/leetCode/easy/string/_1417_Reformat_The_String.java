package com.github.junyu.solution.leetCode.easy.string;

public class _1417_Reformat_The_String {


    /*Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

    You have to find a permutation of the string where no letter is followed by another letter and no digit is followed
    by another digit. That is, no two adjacent characters have the same type.

    Return the reformatted string or return an empty string if it is impossible to reformat the string.

    Example 1:

    Input: s = "a0b1c2"
    Output: "0a1b2c"
    Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also
    valid permutations.
    Example 2:

    Input: s = "leetcode"
    Output: ""
    Explanation: "leetcode" has only characters so we cannot separate them by digits.
    Example 3:

    Input: s = "1229857369"
    Output: ""
    Explanation: "1229857369" has only digits so we cannot separate them by characters.
    Example 4:

    Input: s = "covid2019"
    Output: "c2o0v1i9d"
    Example 5:

    Input: s = "ab123"
    Output: "1a2b3"

    Constraints:
    1 <= s.length <= 500
    s consists of only lowercase English letters and/or digits.
*/

    /**
     * 将字符串中的字母和数字错开
     * 解题思路：首先统计一下字母和数字出现的个数，如果字母和数字之间的差值大于1个以上，那么就无法实现错开操作。
     * 然后就是看字母与数字两者谁的数量更多，数量较多的一方存放在数组的偶数索引位。
     * 最后就是遍历字符串，将每一个字符存放在指定的位置。
     *
     * @param s
     * @return
     */
    public String reformat(String s) {
        int letterNum = 0;
        int digitNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                digitNum++;
            } else {
                letterNum++;
            }
        }

        if (Math.abs(letterNum - digitNum) > 1)
            return "";

        char ans[] = new char[s.length()];
        int letterPoint = letterNum > digitNum ? 0 : 1;
        int digitPoint = letterPoint == 1 ? 0 : 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {//优先添加较小的指针
                ans[digitPoint] = s.charAt(i);
                digitPoint += 2;
            } else {
                ans[letterPoint] = s.charAt(i);
                letterPoint += 2;
            }
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        _1417_Reformat_The_String test = new _1417_Reformat_The_String();
        System.out.println(test.reformat("a0b1c2"));
        System.out.println(test.reformat("leetcode"));
        System.out.println(test.reformat("1229857369"));
        System.out.println(test.reformat("covid2019"));
        System.out.println(test.reformat("ab123"));
    }
}
