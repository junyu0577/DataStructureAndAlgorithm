package com.github.junyu.solution.leetCode.easy.string;

public class _345_Reverse_Vowels_of_a_String {

    /*Write a function that takes a string as input and reverse only the vowels of a string.

            Example 1:

    Input: "hello"
    Output: "holle"
    Example 2:

    Input: "leetcode"
    Output: "leotcede"
    Note:
    The vowels does not include the letter "y".*/

    /**
     * 翻转字符串中所有的元音字母
     * 定义头尾指针，每次从头部位置开始找前面的元音字母，再从尾部往前找元音字母，只要start<end，说明
     * 有需要翻转的字母，交互他们的位置。然后继续从start位置开始往找，再从end位置往前找。直到start<end结束寻找。
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null)
            return null;

        int start = 0;
        int end = s.length() - 1;

        char[] cs = s.toCharArray();

        while (start < end) {
            while (!checkVowel(cs[start]) && start < end)
                start++;

            while (!checkVowel(cs[end]) && start < end)
                end--;

            if (start < end) {
                char temp = cs[start];
                cs[start] = cs[end];
                cs[end] = temp;
                start++;
                end--;
            }
        }


        return new String(cs);
    }

    private boolean checkVowel(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _345_Reverse_Vowels_of_a_String reverse_vowels_of_a_string = new _345_Reverse_Vowels_of_a_String();
        System.out.println(reverse_vowels_of_a_string.reverseVowels("hello"));
        System.out.println(reverse_vowels_of_a_string.reverseVowels("leetcode"));
        System.out.println(reverse_vowels_of_a_string.reverseVowels("OE"));
        System.out.println(reverse_vowels_of_a_string.reverseVowels(".,"));
    }

}
