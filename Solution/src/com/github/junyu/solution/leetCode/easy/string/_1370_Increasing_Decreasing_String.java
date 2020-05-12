package com.github.junyu.solution.leetCode.easy.string;

public class _1370_Increasing_Decreasing_String {

   /* Given a string s. You should re-order the string using the following algorithm:

    Pick the smallest character from s and append it to the result.
    Pick the smallest character from s which is greater than the last appended character to the result and append it.
    Repeat step 2 until you cannot pick more characters.
    Pick the largest character from s and append it to the result.
    Pick the largest character from s which is smaller than the last appended character to the result and append it.
    Repeat step 5 until you cannot pick more characters.
    Repeat the steps from 1 to 6 until you pick all characters from s.
    In each step, If the smallest or the largest character appears more than once you can choose any
    occurrence and append it to the result.

    Return the result string after sorting s with this algorithm.

    Example 1:

    Input: s = "aaaabbbbcccc"
    Output: "abccbaabccba"
    Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
    After steps 4, 5 and 6 of the first iteration, result = "abccba"
    First iteration is done. Now s = "aabbcc" and we go back to step 1
    After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
    After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
    Example 2:

    Input: s = "rat"
    Output: "art"
    Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
    Example 3:

    Input: s = "leetcode"
    Output: "cdelotee"
    Example 4:

    Input: s = "ggggggg"
    Output: "ggggggg"
    Example 5:

    Input: s = "spo"
    Output: "ops"


    Constraints:

    1 <= s.length <= 500
    s contains only lower-case English letters.*/

    /**
     * 1.从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     * 2.从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     * 3.重复步骤 2 ，直到你没法从 s 中选择字符。
     * 4.从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     * 5.从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     * 6.重复步骤 5 ，直到你没法从 s 中选择字符。
     * 7.重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
     *
     * 先统计字符串中个字符出现的次数，然后通过遍历数组进行字符的组织，根据题意是先按升序查找，每添加一个元素就需要将统计的数组对应的元素数量-1，
     * 然后再判断剩余是否还有元素，只要这26个字符存在任意一个元素，那么数组仍然是非空的。
     * 遍历完升序后，然后遍历降序的，从数组末尾开始，判断同升序。只要维护好isEmpty变量即可，
     * 在升序查找后可能存在数组已经没有元素的情况，那么可以直接跳出while循环。
     * @param s
     * @return
     */
    public String sortString(String s) {
        int cs[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i) - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        boolean isEmpty = false;
        while (!isEmpty) {
            isEmpty = increasingString(cs, ans);
            if (isEmpty)
                break;

            isEmpty = decreasingString(cs, ans);
        }

        return ans.toString();
    }

    private boolean decreasingString(int[] cs, StringBuilder ans) {
        boolean isEmpty = true;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] > 0) {
                ans.append((char) (i + 'a'));
                cs[i]--;
            }
            if (cs[i]>0) {
                isEmpty = false;
            }
        }

        return isEmpty;
    }

    private boolean increasingString(int[] cs, StringBuilder ans) {
        boolean isEmpty = true;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] > 0) {
                ans.append((char) (i + 'a'));
                cs[i]--;
            }
            if (cs[i]>0) {
                isEmpty = false;
            }
        }

        return isEmpty;

    }

    public static void main(String[] args) {
        _1370_Increasing_Decreasing_String test = new _1370_Increasing_Decreasing_String();
        System.out.println(test.sortString("aaaabbbbcccc"));
        System.out.println(test.sortString("rat"));
        System.out.println(test.sortString("leetcode"));
        System.out.println(test.sortString("ggggggg"));
        System.out.println(test.sortString("spo"));
        System.out.println(test.sortString("aa"));
        System.out.println(test.sortString("jkzkydvxewqjfx"));
    }
}
