package com.github.junyu.solution.leetCode.easy.array;

public class _1869_Longer_Contiguous_Segments_of_Ones_than_Zeros {

    /* Given a binary string s, return true if the longest contiguous segment of 1s is strictly longer than the longest
     contiguous segment of 0s in s. Return false otherwise.

     For example, in s = "110100010" the longest contiguous segment of 1s has length 2, and the longest contiguous
     segment
     of 0s has length 3.
     Note that if there are no 0s, then the longest contiguous segment of 0s is considered to have length 0. The same
      applies
     if there are no 1s.

      Example 1:

     Input: s = "1101"
     Output: true
     Explanation:
     The longest contiguous segment of 1s has length 2: "1101"
     The longest contiguous segment of 0s has length 1: "1101"
     The segment of 1s is longer, so return true.
     Example 2:

     Input: s = "111000"
     Output: false
     Explanation:
     The longest contiguous segment of 1s has length 3: "111000"
     The longest contiguous segment of 0s has length 3: "111000"
     The segment of 1s is not longer, so return false.
     Example 3:

     Input: s = "110100010"
     Output: false
     Explanation:
     The longest contiguous segment of 1s has length 2: "110100010"
     The longest contiguous segment of 0s has length 3: "110100010"
     The segment of 1s is not longer, so return false.


     Constraints:

             1 <= s.length <= 100
     s[i] is either '0' or '1'.
 */

    /**
     * 哪种连续子字符串更长，最长1连成的字串大于0连成的字串，则返回true，求情况返回false
     * <p>
     * 定义两个变量分别保存0和1出现的最大连续字串数量，定义start用于记录0与1的交替位置。
     * 遍历字符数组，当出现0与1交替时，统计当前位置到上一次交替位置的长度。如果长度超过上一次的最大长度则更新，并将i+1设置为新的交替位。
     * 最后，还需要判断最后一个元素与上一个交替位的元素是否相同，如果相同，则还需要判定以下是否满足更大长度。
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longer Contiguous Segments of Ones than Zeros.
     * Memory Usage: 37 MB, less than 76.12% of Java online submissions for Longer Contiguous Segments of Ones than
     * Zeros.
     *
     * @param s
     * @return
     */
    public boolean checkZeroOnes(String s) {
        int oneCount = 0;
        int zeroCount = 0;
        int start = 0;

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] != cs[i + 1]) {
                if (cs[i] == '0') {
                    zeroCount = Math.max(zeroCount, i - start + 1);
                } else {//1
                    oneCount = Math.max(oneCount, i - start + 1);
                }
                start = i + 1;
            }
        }

        if (cs[start] == cs[cs.length - 1]) {
            if (cs[start] == '0') {
                zeroCount = Math.max(zeroCount, cs.length - start);
            } else {
                oneCount = Math.max(oneCount, cs.length - start);
            }
        }

        return oneCount > zeroCount;
    }

    public static void main(String[] args) {
        _1869_Longer_Contiguous_Segments_of_Ones_than_Zeros test =
                new _1869_Longer_Contiguous_Segments_of_Ones_than_Zeros();
        System.out.println(test.checkZeroOnes("10"));
        System.out.println(test.checkZeroOnes("1101"));
        System.out.println(test.checkZeroOnes("111000"));
        System.out.println(test.checkZeroOnes("111001"));
        System.out.println(test.checkZeroOnes("110100010"));
    }
}
