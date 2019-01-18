package com.github.junyu.solution.leetCode.easy.hashTable;


public class _409_Longest_Palindrome {

    /*Given a string which consists of lowercase or uppercase letters,
    find the length of the longest palindromes that can be built with those letters.

    This is case sensitive, for example "Aa" is not considered a palindrome here.

    Note:
    Assume the length of given string will not exceed 1,010.

    Example:

    Input:
            "abccccdd"

    Output:
            7

    Explanation:
    One longest palindrome that can be built is "dccaccd", whose length is 7.
    */

    /**
     * 求给定的字符串的能够组成最长的回文串的长度
     * 利用贪心算法求解，假设aaaaa这样的组合，以中间的a为中心，左右两边需要4个配对的字符，才能组成
     * 一个合法的回文，那么可以得出某一个字符的出现字数/2*2就是可以配对的数量。得到的结果是4，这个时候
     * 需要查看之前统计的所有配对数，如果是偶数，那么还需要累加上这个中心点a。如果是奇数则忽略。
     * 另一种情况是某一个字符只出现了4次，某另一个字母出现1次。在这种情况下，1+4能够组成回文的，
     * 所以这个1也需要被统计进来，因此判断当当前的配对的是偶数的情况下，再有一个单个的字符，那么就统计进来。
     * 如果之后又有单个字符，那么是始终无法合并进来构成回文的，所有忽略掉。
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int hash[] = new int[128];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }

        int ans = 0;
        for (int count : hash) {
            ans += count / 2 * 2;
            if (ans % 2 == 0 && count % 2 == 1)
                ans++;
        }
        return ans;

    }

    public static void main(String[] args) {
        _409_Longest_Palindrome longest_palindrome = new _409_Longest_Palindrome();
        System.out.println(longest_palindrome.longestPalindrome("abcd"));
        System.out.println(longest_palindrome.longestPalindrome("abcc"));
        System.out.println(longest_palindrome.longestPalindrome("abcddd"));
        System.out.println(longest_palindrome.longestPalindrome("abcddd"));
        System.out.println(longest_palindrome.longestPalindrome("aaaabb"));


    }
}
