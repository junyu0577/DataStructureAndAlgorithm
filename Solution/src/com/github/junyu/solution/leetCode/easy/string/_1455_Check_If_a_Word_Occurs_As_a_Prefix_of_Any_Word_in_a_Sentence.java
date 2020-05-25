package com.github.junyu.solution.leetCode.easy.string;

public class _1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence {

    /*Given a sentence that consists of some words separated by a single space, and a searchWord.

    You have to check if searchWord is a prefix of any word in sentence.

    Return the index of the word in sentence where searchWord is a prefix of this
    word (1-indexed).

    If searchWord is a prefix of more than one word, return the index of the first
    word (minimum index). If there is no such word return -1.

    A prefix of a string S is any leading contiguous substring of S.



            Example 1:

    Input: sentence = "i love eating burger", searchWord = "burg"
    Output: 4
    Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
            Example 2:

    Input: sentence = "this problem is an easy problem", searchWord = "pro"
    Output: 2
    Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th
    word in the sentence, but we return 2 as it's the minimal index.
    Example 3:

    Input: sentence = "i am tired", searchWord = "you"
    Output: -1
    Explanation: "you" is not a prefix of any word in the sentence.
    Example 4:

    Input: sentence = "i use triple pillow", searchWord = "pill"
    Output: 4
    Example 5:

    Input: sentence = "hello from the other side", searchWord = "they"
    Output: -1


    Constraints:

            1 <= sentence.length <= 100
            1 <= searchWord.length <= 10
    sentence consists of lowercase English letters and spaces.
    searchWord consists of lowercase English letters.*/

    /**
     * searchWord是否是sentence中某一个单词的前缀
     * 思路：通过startsWith来判断是否是前缀。
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        _1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence test = new _1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence();
        System.out.println(test.isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(test.isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(test.isPrefixOfWord("i am tired", "you"));
        System.out.println(test.isPrefixOfWord("hello from the other side", "they"));
    }
}
