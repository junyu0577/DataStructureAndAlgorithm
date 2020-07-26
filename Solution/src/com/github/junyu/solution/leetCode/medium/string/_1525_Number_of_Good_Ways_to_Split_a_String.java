package com.github.junyu.solution.leetCode.medium.string;


public class _1525_Number_of_Good_Ways_to_Split_a_String {


    /*You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q
    where its concatenation is equal to s and the number of distinct letters in p and q are the same.

    Return the number of good splits you can make in s.

    Example 1:

    Input: s = "aacaba"
    Output: 2
    Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
            ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
            ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
            ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
            ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
            ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
    Example 2:

    Input: s = "abcd"
    Output: 1
    Explanation: Split the string as follows ("ab", "cd").
    Example 3:

    Input: s = "aaaaa"
    Output: 4
    Explanation: All possible splits are good.
            Example 4:

    Input: s = "acbadbaada"
    Output: 2


    Constraints:

    s contains only lowercase English letters.
            1 <= s.length <= 10^5*/

    /**
     * 分割字符串使两边不同的字符数量相等，有多少种可能
     * 思路：将统计字符出现的次数，然后将字符串从左到右依次排除一个字符，并加到leftCountArr数组中(如果数组中字符还未出现过则leftCount+1)，每次排除一个后，将leftCount和
     * count中剩余的不同数量做对比，相等则ans+1。
     *
     * @param s
     * @return
     */
    public int numSplits(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] leftCountArr = new int[26];
        int leftCount = 0;

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            count[s.charAt(i) - 'a']--;
            if (leftCountArr[index] == 0){
                leftCountArr[index]++;
                leftCount++;
            }
            int tempCount = 0;
            for (int j = 0; j < count.length; j++) {
                if (count[j] > 0)
                    tempCount++;
            }
            if (tempCount == leftCount)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        _1525_Number_of_Good_Ways_to_Split_a_String test = new _1525_Number_of_Good_Ways_to_Split_a_String();
        System.out.println(test.numSplits("aacaba"));
        System.out.println(test.numSplits("abcd"));
        System.out.println(test.numSplits("aaaaa"));
        System.out.println(test.numSplits("acbadbaada"));
    }
}
