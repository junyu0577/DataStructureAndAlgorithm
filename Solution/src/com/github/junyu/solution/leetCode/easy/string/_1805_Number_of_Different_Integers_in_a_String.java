package com.github.junyu.solution.leetCode.easy.string;

import java.util.HashSet;
import java.util.Set;

public class _1805_Number_of_Different_Integers_in_a_String {

    /*
    You are given a string word that consists of digits and lowercase English letters.

    You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will
    become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space:
    "123", "34", "8", and "34".

    Return the number of different integers after performing the replacement operations on word.

    Two integers are considered different if their decimal representations without any leading zeros are different.

    Example 1:

    Input: word = "a123bc34d8ef34"
    Output: 3
    Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
    Example 2:

    Input: word = "leet1234code234"
    Output: 2
    Example 3:

    Input: word = "a1b01c001"
    Output: 1
    Explanation: The three integers "1", "01", and "001" all represent the same integer because
    the leading zeros are ignored when comparing their decimal values.


    Constraints:

            1 <= word.length <= 1000
    word consists of digits and lowercase English letters.
    */


    /**
     * 字符串中不同整数的数目
     * 遍历字符串，遇到字母字符后，先判断sb的长度，如果有值则进行去零操作。如果sb的长度为0，则表示字母开头，还没添加任何数字字符到sb中。
     * 去零操作是通过遍历sb，只要遇到非0的字符，就记录当前索引位置。最后，如果记录的索引为默认值-1，则说明整个数字串都为0.反之，从索引为开始截取内容。
     *
     * Runtime: 2 ms, faster than 83.25% of Java online submissions for Number of Different Integers in a String.
     * Memory Usage: 37.3 MB, less than 73.27% of Java online submissions for Number of Different Integers in a String.
     *
     * @param word
     * @return
     */
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                if (sb.length() == 0)
                    continue;


                set.add(removeZero(sb));
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (sb.length() != 0) {
            set.add(removeZero(sb));
        }

        return set.size();
    }

    /**
     * 将数字去除前置的0后返回
     * @param sb
     * @return
     */
    private String removeZero(StringBuilder sb) {
        int start = -1;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;
            }
        }

        return start == -1 ? "0" : sb.substring(start);
    }

    public static void main(String[] args) {
        _1805_Number_of_Different_Integers_in_a_String test = new _1805_Number_of_Different_Integers_in_a_String();
        System.out.println(test.numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(test.numDifferentIntegers("leet1234code234"));
        System.out.println(test.numDifferentIntegers("a1b01c001"));
        System.out.println(test.numDifferentIntegers("ubhb4xkon7yxlr0007c"));
    }
}
