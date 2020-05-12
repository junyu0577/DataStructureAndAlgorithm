package com.github.junyu.solution.leetCode.medium.string;


public class _1358_Number_of_Substrings_Containing_All_Three_Characters {

    /*Given a string s consisting only of characters a, b and c.

    Return the number of substrings containing at least one occurrence of all these characters a, b and c.

    Example 1:

    Input: s = "abcabc"
    Output: 10
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca",
    "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
    Example 2:

    Input: s = "aaacb"
    Output: 3
    Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb"
    and "acb".
    Example 3:

    Input: s = "abc"
    Output: 1


    Constraints:

   3 <= s.length <= 5 x 10^4
    s only consists of a, b or c characters.*/

    /**
     * 统计字符串中同时包含abc三个字符的子串数量
     * 思路:利用滑动窗口算法，利用两个指针指向字符串的起始和末尾位置。
     * 先移动右边的指针也就是right，并且同时统计abc字符出现的次数。
     * 不断的右移直到发现同时存在abc的子串，此时，从right位置开始后面的元素的加入都符合条件，因为就不需要再往后移，
     * 直接将后面的剩余的次数统计进来，也就是len-right，不需要减1是因为当前位置也是符合条件的一种类型。
     * 然后将左指针指向的字符的出现次数减1，开始移动左边的指针。如果剩余的子串仍然符合条件，那就继续移动左指针，直到不符合条件位置。
     * 最后，只要right还没有移动到末尾，就继续移动right，直到发现有符合条件的。
     *
     * @param s
     * @return
     */
    public int numberOfSubstrings(String s) {
        int left = 0, right = 0, count = 0;
        char[] cs = new char[3];
        int len = s.length();
        while (right < len) {
            cs[s.charAt(right) - 'a']++;
            while (cs[0] > 0 && cs[1] > 0 && cs[2] > 0) {
                count += len - right;
                cs[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        _1358_Number_of_Substrings_Containing_All_Three_Characters test =
                new _1358_Number_of_Substrings_Containing_All_Three_Characters();
        System.out.println(test.numberOfSubstrings("abcabc"));
        System.out.println(test.numberOfSubstrings("aaacb"));
        System.out.println(test.numberOfSubstrings("abc"));
        System.out.println(test.numberOfSubstrings("ababbbc"));
    }
}
