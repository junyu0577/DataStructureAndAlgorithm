package com.github.junyu.solution.leetCode.medium.string;

public class _424_Longest_Repeating_Character_Replacement {

    /*Given a string s that consists of only uppercase English letters, you can perform at most k
    operations on that string.

    In one operation, you can choose any character of the string and change it to any other uppercase
    English character.

    Find the length of the longest sub-string containing all repeating letters you can get after performing
    the above operations.

    Note:
    Both the string's length and k will not exceed 104.

    Example 1:

    Input:
    s = "ABAB", k = 2

    Output:
            4

    Explanation:
    Replace the two 'A's with two 'B's or vice versa.


    Example 2:

    Input:
    s = "AABABBA", k = 1

    Output:
            4

    Explanation:
    Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.*/

    /**
     * 求替换k个字符后最长子串的长度
     * 思路：利用滑动窗口算法，在移动右指针的过程中，同时统计当前出现次数最多的元素的数量，然后查看当前窗口长度减去出现最多次数的元素个数的值是否大于k，
     * 如果大于k则意味着已经不够替换了，开始移动左指针移动窗口,并且从窗口中剔除最左边的元素。
     * 如果小于k，那么意味着仍然还有可替换的剩余空间，则继续移动右指针，同时更新最长子串的长度。
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int max = 0, left = 0, right = 0, len = s.length();
        int[] freq = new int[26];
        int maxFreqCount = 0;
        while (right < len) {
          maxFreqCount = Math.max(maxFreqCount,++freq[s.charAt(right)-'A']);
          int windowLen = right-left+1;
          if (windowLen-maxFreqCount<=k)
              max = Math.max(max,windowLen);
          else
              freq[s.charAt(left++)-'A']--;
          right++;
        }
        return max;
    }

//    public int characterReplacement(String s, int k) {
//        int[] freq = new int[26];
//        int mostFreqLetter = 0;
//        int left = 0, res = 0;
//        for(int right = 0; right < s.length(); right++){
//            freq[s.charAt(right) - 'A']++;
//            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);
//
//            int lettersToChange = (right - left + 1) - mostFreqLetter;
//            while(right - left + 1 - mostFreqLetter > k){
//                freq[s.charAt(left) - 'A']--;
//                left++;
//            }
//            res = Math.max(res, right + 1 - left);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        _424_Longest_Repeating_Character_Replacement test = new _424_Longest_Repeating_Character_Replacement();
        System.out.println(test.characterReplacement("ABAB", 2));
        System.out.println(test.characterReplacement("AABABBA", 1));
    }
}
