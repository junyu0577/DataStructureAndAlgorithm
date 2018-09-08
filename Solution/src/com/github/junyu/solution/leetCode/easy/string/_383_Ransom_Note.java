package com.github.junyu.solution.leetCode.easy.string;

public class _383_Ransom_Note {

  /*  Given an arbitrary ransom note string and another string containing letters from
    all the magazines, write a function that will return true if the ransom note can be
    constructed from the magazines ; otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

            Note:
    You may assume that both strings contain only lowercase letters.

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true*/

    /**
     * 判断magazine中的字符能否构成ransomNote字符串
     * 利用hash表统计magazine每个字符出现的字符，最后遍历hash表，如果当前遍历到的字符的次数已经是0了，那么也就
     * 无法构成ransomNote字符串了。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null)
            return false;

        int arr[] = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i) - 'a']-- == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _383_Ransom_Note().canConstruct("a", "b"));
        System.out.println(new _383_Ransom_Note().canConstruct("aa", "ab"));
        System.out.println(new _383_Ransom_Note().canConstruct("aa", "aab"));
        System.out.println(new _383_Ransom_Note().canConstruct("", ""));
    }
}
