package com.github.junyu.solution.leetCode.easy.string;

public class _1880_Check_if_Word_Equals_Summation_of_Two_Words {

   /*
    The letter value of a letter is its position in the alphabet starting from 0 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2,
    etc.).

    The numerical value of some string of lowercase English letters s is the concatenation of the letter values of
    each letter in s,
    which is then converted into an integer.

    For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we
     get 21.
    You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase English letters 'a'
    through 'j' inclusive.

            Return true if the summation of the numerical values of firstWord and secondWord equals the numerical
            value of targetWord,
    or false otherwise.



            Example 1:

    Input: firstWord = "acb", secondWord = "cba", targetWord = "cdb"
    Output: true
    Explanation:
    The numerical value of firstWord is "acb" -> "021" -> 21.
    The numerical value of secondWord is "cba" -> "210" -> 210.
    The numerical value of targetWord is "cdb" -> "231" -> 231.
    We return true because 21 + 210 == 231.
    Example 2:

    Input: firstWord = "aaa", secondWord = "a", targetWord = "aab"
    Output: false
    Explanation:
    The numerical value of firstWord is "aaa" -> "000" -> 0.
    The numerical value of secondWord is "a" -> "0" -> 0.
    The numerical value of targetWord is "aab" -> "001" -> 1.
    We return false because 0 + 0 != 1.
    Example 3:

    Input: firstWord = "aaa", secondWord = "a", targetWord = "aaaa"
    Output: true
    Explanation:
    The numerical value of firstWord is "aaa" -> "000" -> 0.
    The numerical value of secondWord is "a" -> "0" -> 0.
    The numerical value of targetWord is "aaaa" -> "0000" -> 0.
    We return true because 0 + 0 == 0.


    Constraints:

            1 <= firstWord.length, secondWord.length, targetWord.length <= 8
    firstWord, secondWord, and targetWord consist of lowercase English letters from 'a' to 'j' inclusive.
    */

//    /**
//     * 检查某单词是否等于两单词之和
//     *
//     * 将字符串转成对应的数字后，强转为int并相加再与targetWord对应的数字进行比较
//     *
//     * Runtime: 1 ms, faster than 51.72% of Java online submissions for Check if Word Equals Summation of Two Words.
//     * Memory Usage: 38.6 MB, less than 61.60% of Java online submissions for Check if Word Equals Summation of Two
//     Words.
//     *
//     * @param firstWord
//     * @param secondWord
//     * @param targetWord
//     * @return
//     */
//    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
//        StringBuilder firstWordSb = new StringBuilder();
//        StringBuilder secondWordSb = new StringBuilder();
//        StringBuilder targetWordSb = new StringBuilder();
//
//        for (char c : firstWord.toCharArray()){
//            firstWordSb.append(c-'a');
//        }
//
//        for (char c : secondWord.toCharArray()){
//            secondWordSb.append(c-'a');
//        }
//
//        for (char c : targetWord.toCharArray()){
//            targetWordSb.append(c-'a');
//        }
//
//        return (Integer.parseInt(firstWordSb.toString())+Integer.parseInt(secondWordSb.toString()))==Integer
//        .parseInt(targetWordSb.toString());
//    }

    /**
     * 检查某单词是否等于两单词之和
     * 相对于上一个方法，这里的字符串计算方法进行了更改，除了第一个字符外，后面的每一个字符追加都需要*10后再累加。
     *
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if Word Equals Summation of Two Words.
     * Memory Usage: 37.4 MB, less than 79.74% of Java online submissions for Check if Word Equals Summation of Two Words.
     *
     * @param firstWord
     * @param secondWord
     * @param targetWord
     * @return
     */
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int index = 0;
        int first = firstWord.charAt(index)-'a', second = secondWord.charAt(index)-'a', target = targetWord.charAt(index)-'a';
        while (index < firstWord.length() || index < secondWord.length() || index < targetWord.length()) {
            index++;
            if (index < firstWord.length()) {
                first = first * 10 + (firstWord.charAt(index)-'a');
            }
            if (index < secondWord.length()) {
                second = second * 10 + (secondWord.charAt(index)-'a');
            }
            if (index < targetWord.length()) {
                target = target * 10 + (targetWord.charAt(index)-'a');
            }
        }
        return first + second == target;
    }

    public static void main(String[] args) {
        _1880_Check_if_Word_Equals_Summation_of_Two_Words test =
                new _1880_Check_if_Word_Equals_Summation_of_Two_Words();
        System.out.println(test.isSumEqual("acb", "cba", "cdb"));
        System.out.println(test.isSumEqual("aaa", "a", "aab"));
        System.out.println(test.isSumEqual("aaa", "a", "aaaa"));
        System.out.println(test.isSumEqual("d", "b", "aaaaae"));
    }

}
