package com.github.junyu.solution.leetCode.easy.string;

public class _1446_Consecutive_Characters {

    /*Given a string s, the power of the string is the maximum length of a non-empty
    substring that contains only one unique character.

    Return the power of the string.



    Example 1:

    Input: s = "leetcode"
    Output: 2
    Explanation: The substring "ee" is of length 2 with the character 'e' only.
            Example 2:

    Input: s = "abbcccddddeeeeedcba"
    Output: 5
    Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
            Example 3:

    Input: s = "triplepillooooow"
    Output: 5
    Example 4:

    Input: s = "hooraaaaaaaaaaay"
    Output: 11
    Example 5:

    Input: s = "tourist"
    Output: 1


    Constraints:

            1 <= s.length <= 500
    s contains only lowercase English letters.
*/

    /**
     * 最长连续子串
     * 思路：遍历数组，如果相邻的两个元素相同，则count+1并且更新max值，如果不同就让count重新从1
     * 开始统计。
     * @param s
     * @return
     */
    public int maxPower(String s) {
        int max = 1;
        int count = 1;
        int len = s.length();

        for (int i=0;i<len-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                count++;
                max = Math.max(count,max);
            }else
                count=1;
        }
        return max;
    }

    public static void main(String[] args) {
        _1446_Consecutive_Characters test = new _1446_Consecutive_Characters();
        System.out.println(test.maxPower("leetcode"));
        System.out.println(test.maxPower("abbcccddddeeeeedcba"));
        System.out.println(test.maxPower("triplepillooooow"));
        System.out.println(test.maxPower("hooraaaaaaaaaaay"));
        System.out.println(test.maxPower("tourist"));
        System.out.println(test.maxPower("ccbccbb"));
    }
}
