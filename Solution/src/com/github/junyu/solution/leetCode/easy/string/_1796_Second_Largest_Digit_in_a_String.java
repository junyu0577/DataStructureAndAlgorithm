package com.github.junyu.solution.leetCode.easy.string;


public class _1796_Second_Largest_Digit_in_a_String {

    /*
    Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

    An alphanumeric string is a string consisting of lowercase English letters and digits.

    Example 1:

    Input: s = "dfa12321afd"
    Output: 2
    Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

    Example 2:

    Input: s = "abc1111"
    Output: -1
    Explanation: The digits that appear in s are [1]. There is no second largest digit.


    Constraints:

            1 <= s.length <= 500
    s consists of only lowercase English letters and/or digits.
    */

    /**
     * 字符串中第二大的数字
     *
     * 首先将字符串中出现的数字统计到hash表中，然后从末尾开始遍历hash表，用findFirst变量去记录找了最大值，当findFirst为true且当前的元素大于0，就表示找到了第二大数值。
     *
     *
     * Runtime: 1 ms, faster than 99.53% of Java online submissions for Second Largest Digit in a String.
     * Memory Usage: 37.5 MB, less than 83.07% of Java online submissions for Second Largest Digit in a String.
     *
     * @param s
     * @return
     */
    public int secondHighest(String s) {
        int [] hash = new int[10];
        boolean findFirst = false;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isDigit(c))
                hash[c-'0']++;
        }

        for (int i=hash.length-1;i>=0;i--){
            if (hash[i]>0){
                if (!findFirst){
                    findFirst = true;
                } else {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        _1796_Second_Largest_Digit_in_a_String test = new _1796_Second_Largest_Digit_in_a_String();
        System.out.println(test.secondHighest("dfa12321afd"));
        System.out.println(test.secondHighest("abc1111"));
    }
}
