package com.github.junyu.solution.leetCode.easy.string;

public class _1957_Delete_Characters_to_Make_Fancy_String {

/*

    A fancy string is a string where no three consecutive characters are equal.

    Given a string s, delete the minimum possible number of characters from s
    to make it fancy.

    Return the final string after the deletion. It can be shown that
    the answer will always be unique.



    Example 1:

    Input: s = "leeetcode"
    Output: "leetcode"
    Explanation:
    Remove an 'e' from the first group of 'e's to create "leetcode".
    No three consecutive characters are equal, so return "leetcode".
    Example 2:

    Input: s = "aaabaaaa"
    Output: "aabaa"
    Explanation:
    Remove an 'a' from the first group of 'a's to create "aabaaaa".
    Remove two 'a's from the second group of 'a's to create "aabaa".
    No three consecutive characters are equal, so return "aabaa".
    Example 3:

    Input: s = "aab"
    Output: "aab"
    Explanation: No three consecutive characters are equal, so return "aab".


    Constraints:

            1 <= s.length <= 105
    s consists only of lowercase English letters

*/

    /**
     * 删除字符使字符串变好（字符串中不能出现三次连续相同的字符）
     *
     * 遍历字符串，同时使用一个count去记录上一个字符出现的次数。
     * 如果当前的字符与上一个字符不同，那么就直接加入到sb中，并且更新上一个字符值和重置count为1。
     * 如果字符相同，那么判断count的数量，小于2时就可以追加。
     *
     * Runtime: 28 ms, faster than 91.48% of Java online submissions for Delete Characters to Make Fancy String.
     * Memory Usage: 39.9 MB, less than 95.24% of Java online submissions for Delete Characters to Make Fancy String.
     * @param s
     * @return
     */
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char lastChar = s.charAt(0);
        sb.append(lastChar);
        int count = 1;
        for (int i=1;i<s.length();i++){
            char cur = s.charAt(i);
            if (lastChar != cur){
                count = 1;
                sb.append(cur);
                lastChar = cur;
            }else {
                if (count<2){
                    sb.append(cur);
                    count++;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        _1957_Delete_Characters_to_Make_Fancy_String test = new _1957_Delete_Characters_to_Make_Fancy_String();
        System.out.println(test.makeFancyString("leeetcode"));
        System.out.println(test.makeFancyString("aaabaaaa"));
        System.out.println(test.makeFancyString("aab"));
    }
}
