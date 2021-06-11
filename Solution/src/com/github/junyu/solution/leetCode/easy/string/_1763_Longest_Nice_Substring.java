package com.github.junyu.solution.leetCode.easy.string;


public class _1763_Longest_Nice_Substring {

/*
    A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
    For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears,
    but 'B' does not.

    Given a string s, return the longest substring of s that is nice. If there are multiple,
    return the substring of the earliest occurrence. If there are none, return an empty string.

    Example 1:

    Input: s = "YazaAay"
    Output: "aAa"
    Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.

    Example 2:

    Input: s = "Bb"
    Output: "Bb"
    Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.

    Example 3:

    Input: s = "c"
    Output: ""
    Explanation: There are no nice substrings.

    Example 4:

    Input: s = "dDzeE"
    Output: "dD"
    Explanation: Both "dD" and "eE" are the longest nice substrings.
    As there are multiple longest nice substrings, return "dD" since it occurs earlier.


    Constraints:

            1 <= s.length <= 100
    s consists of uppercase and lowercase English letters.
    */

    /**
     * 最长的美好子字符串
     *
     * 通过穷举所有的子串，去判断每个字符在子串中是否包含大小写。
     *
     * @param s
     * @return
     */
    public String longestNiceSubstring(String s) {
        String ans = "";
        for (int i=0;i<s.length()-1;i++){
            for (int j=i+1;j<s.length();j++){
                String str = s.substring(i,j+1);
                boolean checked = true;
                for (int k=0;k<str.length();k++){
                    char c = str.charAt(k);
                    if (!str.contains(String.valueOf(Character.toLowerCase(c))) || !str.contains(String.valueOf(Character.toUpperCase(c)))){
                        checked = false;
                        break;
                    }
                }
                if (checked && str.length()>ans.length()){
                    ans = str;
                }
            }

        }
        return ans;
    }



    public static void main(String[] args) {
        _1763_Longest_Nice_Substring test = new _1763_Longest_Nice_Substring();
        System.out.println(test.longestNiceSubstring("YazaAay"));
        System.out.println(test.longestNiceSubstring("Bb"));
        System.out.println(test.longestNiceSubstring("c"));
        System.out.println(test.longestNiceSubstring("dDzeE"));
    }
}
