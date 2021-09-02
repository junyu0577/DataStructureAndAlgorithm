package com.github.junyu.solution.leetCode.easy.string;

public class _1945_Sum_of_Digits_of_String_After_Convert {

/*

    You are given a string s consisting of lowercase English letters,
     and an integer k.

    First, convert s into an integer by replacing each letter with its
    position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26).
    Then, transform the integer by replacing it with the sum of its digits.
    Repeat the transform operation k times in total.

    For example, if s = "zbax" and k = 2, then the resulting integer would
    be 8 by the following operations:

    Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
    Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
    Transform #2: 17 ➝ 1 + 7 ➝ 8
    Return the resulting integer after performing the operations described above.



    Example 1:

    Input: s = "iiii", k = 1
    Output: 36
    Explanation: The operations are as follows:
        - Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
        - Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
    Thus the resulting integer is 36.

    Example 2:

    Input: s = "leetcode", k = 2
    Output: 6
    Explanation: The operations are as follows:
        - Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝
        "12552031545" ➝ 12552031545
        - Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
        - Transform #2: 33 ➝ 3 + 3 ➝ 6
    Thus the resulting integer is 6.

    Example 3:

    Input: s = "zbax", k = 2
    Output: 8


    Constraints:

            1 <= s.length <= 100
            1 <= k <= 10
    s consists of lowercase English letters.
*/

    /**
     * 字符串转化后的各位数字之和
     *
     * 因为k至少为1，所以就把字符转数字和统计各位数之和放在了一个步骤进行。
     * 统计各位数之和是通过mod的方式取出各位数然后进行相加。
     * 在重复进行k轮时，将k的次数-1即可。
     *
     * Runtime: 1 ms, faster than 86.93% of Java online submissions for Sum of Digits of String After Convert.
     * Memory Usage: 39 MB, less than 50.36% of Java online submissions for Sum of Digits of String After Convert.
     *
     * @param s
     * @param k
     * @return
     */
    public int getLucky(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += getNumber(s.charAt(i) - 'a' + 1);
        }


        for (int i = 0; i < k - 1; i++) {
            ans = getNumber(ans);
        }

        return ans;
    }

    private int getNumber(int count) {
        int num = 0;
        while (count > 0) {
            num += count % 10;
            count = count / 10;
        }

        return num;
    }

    public static void main(String[] args) {
        _1945_Sum_of_Digits_of_String_After_Convert test = new _1945_Sum_of_Digits_of_String_After_Convert();
        System.out.println(test.getLucky("iiii", 1));
        System.out.println(test.getLucky("leetcode", 2));
        System.out.println(test.getLucky("zbax", 2));
    }
}
