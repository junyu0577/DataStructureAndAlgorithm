package com.github.junyu.solution.leetCode.easy.string;


public class _824_Goat_Latin {

   /* A sentence S is given, composed of words separated by spaces. Each word consists
    of lowercase and uppercase letters only.

    We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

    The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end,
    then add "ma".
    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
    Return the final sentence representing the conversion from S to Goat Latin.



            Example 1:

    Input: "I speak Goat Latin"
    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
    Example 2:

    Input: "The quick brown fox jumped over the lazy dog"
    Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


    Notes:

    S contains only uppercase, lowercase and spaces. Exactly one space between each word.
            1 <= S.length <= 150.*/

    /**
     * 将字符串转为山羊拉丁文
     * 山羊拉丁文的规则如下：
     *
     * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
     * 例如，单词"apple"变为"applema"。
     *
     * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
     * 例如，单词"goat"变为"oatgma"。
     *
     * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
     * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
     *
     * 利用split以空格进行分割，再判断首字母是否是元音字母，做不同的处理就好。
     *
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {
        String ss[] = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            char firstLetter = ss[i].charAt(0);
            if (firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'
                    || firstLetter == 'u' || firstLetter == 'A' || firstLetter == 'E' || firstLetter == 'I'
                    || firstLetter == 'O' || firstLetter == 'U') {
                append(sb, ss[i], i, true);

            } else {
                append(sb, ss[i], i, false);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void append(StringBuilder sb, String s, int i, boolean isVowel) {
        if (isVowel) {
            sb.append(s);
        } else {
            if (s.length() > 1) {
                for (int j = 1; j < s.length(); j++) {
                    sb.append(s.charAt(j));
                }
            }
            sb.append(s.charAt(0));
        }
        sb.append("ma");
        while (i >= 0) {
            sb.append("a");
            i--;
        }
        sb.append(" ");
    }


    public static void main(String[] args) {
        System.out.println(new _824_Goat_Latin().toGoatLatin("apple"));
        System.out.println(new _824_Goat_Latin().toGoatLatin("I speak Goat Latin"));
    }

}
