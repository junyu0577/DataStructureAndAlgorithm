package com.github.junyu.solution.leetCode.easy.string;

public class _1221_Split_a_String_in_Balanced_Strings {

    /*Balanced strings are those who have equal quantity of 'L' and 'R' characters.

    Given a balanced string s split it in the maximum amount of balanced strings.

    Return the maximum amount of splitted balanced strings.

    Example 1:

    Input: s = "RLRRLLRLRL"
    Output: 4
    Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same
    number of 'L' and 'R'.
    Example 2:

    Input: s = "RLLLLRRRLR"
    Output: 3
    Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same
     number of 'L' and 'R'.
    Example 3:

    Input: s = "LLLLRRRR"
    Output: 1
    Explanation: s can be split into "LLLLRRRR".
    Example 4:

    Input: s = "RLRRRLLRLL"
    Output: 2
    Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains
    an equal number of 'L' and 'R'


    Constraints:

            1 <= s.length <= 1000
    s[i] = 'L' or 'R'
    */

    /**
     * RL配对数量
     * 思路:如果LR和数量相等就累加一次计数，因此只要count值等于0，就代表L和R的数量相等。
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int ans = 0;
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'L')
                count++;
            else
                count--;
            if (count == 0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1221_Split_a_String_in_Balanced_Strings test = new _1221_Split_a_String_in_Balanced_Strings();
        System.out.println(test.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(test.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(test.balancedStringSplit("LLLLRRRR"));
        System.out.println(test.balancedStringSplit("RLRRRLLRLL"));
    }
}
