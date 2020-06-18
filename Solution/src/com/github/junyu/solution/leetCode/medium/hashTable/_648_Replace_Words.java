package com.github.junyu.solution.leetCode.medium.hashTable;

import java.util.Arrays;
import java.util.List;

public class _648_Replace_Words {

    /*In English, we have a concept called root, which can be followed by some other words to form
    another longer word - let's call this word successor. For example, the root an, followed by other,
    which can form another word another.

    Now, given a dictionary consisting of many roots and a sentence. You need to replace all the
    successor in the sentence with the root forming it. If a successor has many roots can form it, replace
    it with the root with the shortest length.

    You need to output the sentence after the replacement.

    Example 1:

    Input: dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    Output: "the cat was rat by the bat"


    Constraints:

    The input will only have lower-case letters.
    1 <= dict.length <= 1000
            1 <= dict[i].length <= 100
            1 <= sentence words number <= 1000
            1 <= sentence words length <= 1000
*/

    /**
     * 单词替换
     * 思路：通过startWith去判断是否是前缀，如果存在多个前缀取短的。
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split(" ")) {
            String newString = null;
            for (int i = 0; i < dict.size(); i++) {
                if (s.startsWith(dict.get(i))) {
                    if (newString == null || newString.length() > dict.get(i).length())
                        newString = dict.get(i);
                }
            }
            if (newString != null) {
                sb.append(newString);
            } else {
                sb.append(s);
            }
            sb.append(" ");
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _648_Replace_Words test = new _648_Replace_Words();
        System.out.println(test.replaceWords(Arrays.asList(new String[]{"cat", "bat", "rat"}), "the cattle was " +
                "rattled by the battery"));
    }
}
