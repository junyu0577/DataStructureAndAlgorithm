package com.github.junyu.solution.leetCode.easy.string;

public class _917_Reverse_Only_Letters {

    /*Given a string S, return the "reversed" string where all
    characters that are not a letter stay in the same place, and all letters reverse their positions.



            Example 1:

    Input: "ab-cd"
    Output: "dc-ba"
    Example 2:

    Input: "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"
    Example 3:

    Input: "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"


    Note:

    S.length <= 100
            33 <= S[i].ASCIIcode <= 122
    S doesn't contain \ or "*/


    /**
     * 反转字符串中的字母
     * 定义两个头尾指针，分别指向字符数组的头和尾，然后遍历数组。
     * 每次遍历先从头部开始找到最接近start位置的字母，然后再从尾部向前找最接近end位置的字母，
     * 然后交换start和end位置的元素。当start大于等于end以后，循环结束，完成反转。
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() < 2)
            return S;

        int start = 0;
        int end = S.length() - 1;
        char cs[] = S.toCharArray();
        int len = end + 1;
        while (start < end) {

            while (start < len && !isLetter(cs[start]))
                start++;

            if (start >= end)
                break;

            while (end >= 0 && !isLetter(cs[end]))
                end--;

            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;

            start++;
            end--;

        }

        return new String(cs);
    }

    private boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    public static void main(String[] args) {
        System.out.println(new _917_Reverse_Only_Letters().reverseOnlyLetters("ab-cd"));
        System.out.println(new _917_Reverse_Only_Letters().reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(new _917_Reverse_Only_Letters().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(new _917_Reverse_Only_Letters().reverseOnlyLetters("7_28]"));
    }

}
