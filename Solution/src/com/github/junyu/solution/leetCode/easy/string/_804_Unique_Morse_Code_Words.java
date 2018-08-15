package com.github.junyu.solution.leetCode.easy.string;

import java.util.HashSet;

public class _804_Unique_Morse_Code_Words {

   /* International Morse Code defines a standard encoding
    where each letter is mapped to a series of dots and dashes,
    as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

    For convenience, the full table for the 26 letters of the English alphabet is given below:

        [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
        "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter.
    For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-").
    We'll call such a concatenation, the transformation of a word.

    Return the number of different transformations among all words we have.

            Example:
    Input: words = ["gin", "zen", "gig", "msg"]
    Output: 2
    Explanation:
    The transformation of each word is:
            "gin" -> "--...-."
            "zen" -> "--...-."
            "gig" -> "--...--."
            "msg" -> "--...--."

    There are 2 different transformations, "--...-." and "--...--.".


    Note:

    The length of words will be at most 100.
    Each words[i] will have length in range [1, 12].
    words[i] will only consist of lowercase letters.
    */

   private String [] morseArr = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
            "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    /**
     * 将数组里的字符串分别转换为摩斯码后，有多少不同的莫斯码
     * 建立hash表存放26个字母对应的莫斯码，遍历字符串数组的时候，进行转换。每转换完一个字符串，就存入hashset中，利用key的唯一性去重，
     * 最后集合中的元素个数就是不同的莫斯码的数量。
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        if (words==null || words.length==0)
            return 0;
        HashSet<String> hashSet = new HashSet();
        for (int i=0;i<words.length;i++){
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()){
                sb.append(morseArr[c-'a']);
            }
            hashSet.add(sb.toString());
        }
        return hashSet.size();
    }

    public static void main(String [] args) {
        String [] arr = {"gin", "zen", "gig", "msg"};
        _804_Unique_Morse_Code_Words unique_morse_code_words = new _804_Unique_Morse_Code_Words();
        System.out.println(unique_morse_code_words.uniqueMorseRepresentations(arr));
    }
}
