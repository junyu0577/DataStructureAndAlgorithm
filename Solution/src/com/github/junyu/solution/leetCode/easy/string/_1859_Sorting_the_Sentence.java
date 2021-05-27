package com.github.junyu.solution.leetCode.easy.string;


public class _1859_Sorting_the_Sentence {

/*

    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    Each word consists of lowercase and uppercase English letters.

    A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

    For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
    Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.


    Example 1:

    Input: s = "is2 sentence4 This1 a3"
    Output: "This is a sentence"
    Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
    Example 2:

    Input: s = "Myself2 Me1 I4 and3"
    Output: "Me Myself and I"
    Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.


    Constraints:

            2 <= s.length <= 200
    s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
    The number of words in s is between 1 and 9.
    The words in s are separated by a single space.
    s contains no leading or trailing spaces.
*/

    /**
     * 将句子排序
     * 先将字符串按空格进行分割，然后挨个取出分割后的字符串的末尾的数值，由于数值范围在1-9，因此，可以通过将字符串按数值存放在指定的索引住（需减1）.
     * 最后遍历存放的数组，放索引顺序将字符串追加进sb中。
     *
     * Runtime: 1 ms, faster than 89.53% of Java online submissions for Sorting the Sentence.
     * Memory Usage: 36.9 MB, less than 88.36% of Java online submissions for Sorting the Sentence.
     *
     * @param s
     * @return
     */
    public String sortSentence(String s) {
        String [] arr = s.split(" ");
        String [] container = new String[arr.length];
        for (String str : arr){
           int num =  str.charAt(str.length()-1)-'0';
           container[num-1] = str.substring(0,str.length()-1);
        }

        StringBuilder ans = new StringBuilder();
        for (String str : container){
            ans.append(str+" ");
        }
        ans.deleteCharAt(ans.length()-1);

        return ans.toString();
    }


    public static void main(String[] args) {
        _1859_Sorting_the_Sentence  test = new _1859_Sorting_the_Sentence();
        System.out.println(test.sortSentence("is2 sentence4 This1 a3"));
        System.out.println(test.sortSentence("Myself2 Me1 I4 and3"));
    }
}
