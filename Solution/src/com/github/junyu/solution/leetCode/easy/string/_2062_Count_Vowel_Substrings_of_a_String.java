package com.github.junyu.solution.leetCode.easy.string;

import java.util.HashMap;

public class _2062_Count_Vowel_Substrings_of_a_String {

/*
    A substring is a contiguous (non-empty) sequence of characters within a string.

    A vowel substring is a substring that only consists of vowels
            ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.

    Given a string word, return the number of vowel substrings in word.


    Example 1:

    Input: word = "aeiouu"
    Output: 2
    Explanation: The vowel substrings of word are as follows (underlined):
            - "aeiouu"
            - "aeiouu"


    Example 2:

    Input: word = "unicornarihan"
    Output: 0
    Explanation: Not all 5 vowels are present, so there are no vowel substrings.


    Example 3:

    Input: word = "cuaieuouac"
    Output: 7
    Explanation: The vowel substrings of word are as follows (underlined):
            - "cuaieuouac"
            - "cuaieuouac"
            - "cuaieuouac"
            - "cuaieuouac"
            - "cuaieuouac"
            - "cuaieuouac"
            - "cuaieuouac"


    Example 4:

    Input: word = "bbaeixoubb"
    Output: 0
    Explanation: The only substrings that contain all five vowels also contain consonants,
    so there are no vowel substrings.


    Constraints:

            1 <= word.length <= 100
    word consists of lowercase English letters only.
    */


    /**
     * 统计字符串中的元音子字符串
     * 穷举，定义一个指针作为起始为止，然后向后扫描，只要是元音字母就加入map。如果是元音字母就判断map的长度是否为5，满足5就累加ans。
     * 直到遇到非元音字符，跳出循环，并清空map。
     *
     * Runtime: 13 ms, faster than 57.68% of Java online submissions for Count Vowel Substrings of a String.
     * Memory Usage: 37.6 MB, less than 78.11% of Java online submissions for Count Vowel Substrings of a String.
     * @param word
     * @return
     */
    public int countVowelSubstrings(String word) {
        if (word.length() < 5)
            return 0;

        int ans = 0;
        int point = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (point<word.length()-4){
            if (isVowel(word.charAt(point))) {
                map.put(word.charAt(point), map.getOrDefault(word.charAt(point), 0) + 1);

                for (int i=point+1;i<word.length();i++){
                    char newChar = word.charAt(i);
                    if (isVowel(newChar)) {
                        map.put(newChar, map.getOrDefault(newChar, 0) + 1);
                        if (map.size()==5)
                            ans++;
                    }else {
                        break;
                    }
                }
                map.clear();
            }
            point++;
        }

        return ans;
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;

        return false;
    }

    public static void main(String[] args) {
        _2062_Count_Vowel_Substrings_of_a_String test = new _2062_Count_Vowel_Substrings_of_a_String();
        System.out.println(test.countVowelSubstrings("aeiouu"));
        System.out.println(test.countVowelSubstrings("unicornarihan"));
        System.out.println(test.countVowelSubstrings("cuaieuouac"));
        System.out.println(test.countVowelSubstrings("bbaeixoubb"));
    }

}
