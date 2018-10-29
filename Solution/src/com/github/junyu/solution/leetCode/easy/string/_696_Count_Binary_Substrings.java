package com.github.junyu.solution.leetCode.easy.string;

public class _696_Count_Binary_Substrings {

    /*Give a string s, count the number of non-empty (contiguous)
    substrings that have the same number of 0's and 1's, and all the 0's and all the 1's
    in these substrings are grouped consecutively.

    Substrings that occur multiple times are counted the number of times they occur.

            Example 1:
    Input: "00110011"
    Output: 6
    Explanation: There are 6 substrings that have equal number of
        consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

    Notice that some of these substrings repeat and are counted the number of times they occur.

    Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
    Example 2:
    Input: "10101"
    Output: 4
    Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
            Note:

    s.length will be between 1 and 50,000.
    s will only consist of "0" or "1" characters.*/

//    /**
//     * 数二进制中含有相同数量0和1(0和1需要各自连续)的子串的数量
//     * 定义一个start指针指向字符串的头部，遍历字符串的字符时，for循环的目的是统计出到满足一组连续01组合的子串的末尾位置，
//     * 然后判断开始位置到mid和mid到末尾位置哪一段比较短，短的一方即是该组的有效子串数量。
//     * 最后考虑遍历到末尾时，仍然需要统计从start-末尾中有效子串的数量。
//     * @param s
//     * @return
//     */
//    public int countBinarySubstrings(String s) {
//
//        if (s.length() < 2)
//            return 0;
//
//        int res = 0;
//        int start = 0;
//        while (start < s.length()) {
//            boolean isDiff = false;
//            int mid = 0;
//            for (int i = start + 1; i < s.length(); i++) {
//                if (s.charAt(i) != s.charAt(i - 1)) {
//                    if (!isDiff) {
//                        isDiff = true;
//                        mid = i;
//                    } else {
//                        int count = Math.min(mid - start, i - mid);
//                        res += count;
//
//                        start = mid;
//                        break;
//                    }
//                }
//                if (i == s.length() - 1) {
//                    int count = Math.min(mid - start, i + 1 - mid);
//                    res += count;
//                    start = i + 1;
//                }
//            }
//
//
//        }
//
//        return res;
//
//    }


    /**
     * solution2
     * 使用两个变量去记录之前与当前的连续字符数量，如果前后两个字符相同，当前数量累加。
     * 如果两个字符不相同，那么将当前的字符数量赋值给之前的连续字符变量，并将记录当前数量的变量重置为1。
     * 如果pre>=cur，那么说明当前位置是有符合条件的子串，对res进行累加。
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {

        if (s.length() < 2)
            return 0;

        int res = 0;
        int cur = 1;
        int pre = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }

            if (pre >= cur) {
                res++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        _696_Count_Binary_Substrings count_binary_substrings = new _696_Count_Binary_Substrings();
        System.out.println(count_binary_substrings.countBinarySubstrings("00110011"));
        System.out.println(count_binary_substrings.countBinarySubstrings("10101"));
    }

}
