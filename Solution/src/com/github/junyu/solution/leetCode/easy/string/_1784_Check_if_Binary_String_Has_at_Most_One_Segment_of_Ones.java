package com.github.junyu.solution.leetCode.easy.string;

public class _1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones {

/*
    Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment
    of ones.
    Otherwise, return false.

    Example 1:

    Input: s = "1001"
    Output: false
    Explanation: The ones do not form a contiguous segment.

    Example 2:

    Input: s = "110"
    Output: true


    Constraints:

            1 <= s.length <= 100
    s[i]​​​​ is either '0' or '1'.
    s[0] is '1'.
    */

    /**
     * 检查二进制字符串字段(只包含一组连续的1)
     *
     * 从1号索引位开始遍历字符串，并用hasZero标识0的出现。当遇到1时，如果之前已经有0出现过，则不满足题意。
     *
     *Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if Binary String Has at Most One Segment of Ones.
     * Memory Usage: 37.1 MB, less than 47.88% of Java online submissions for Check if Binary String Has at Most One Segment of Ones.
     *
     * @param s
     * @return
     */
    public boolean checkOnesSegment(String s) {
        boolean hasZero = false;
        for (int i = 1; i < s.length(); i++) {
           if (s.charAt(i)=='0'){
               hasZero = true;
           } else {
               if (hasZero)
                   return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        _1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones test =
                new _1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones();
        System.out.println(test.checkOnesSegment("1001"));
        System.out.println(test.checkOnesSegment("110"));
        System.out.println(test.checkOnesSegment("10"));
        System.out.println(test.checkOnesSegment("1000"));
    }
}
