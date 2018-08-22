package com.github.junyu.solution.leetCode.easy.string;

public class _520_Detect_Capital {

    /*Given a word, you need to judge whether the usage of capitals in it is right or not.

    We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital if it has more than one letter, like "Google".
    Otherwise, we define that this word doesn't use capitals in a right way.
    Example 1:
    Input: "USA"
    Output: True
    Example 2:
    Input: "FlaG"
    Output: False
    Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.*/

    /**
     * 判断字符串的大写是否符合规范：以下三种情况都是规范的：
     * 1.全部字母大写
     * 2.首字母大写
     * 3.所有字母都是小写
     * <p>
     * 如果字符串只有一个字符，那么肯定是规范的。
     * 如果超过两个字符，那么就先查看第一个和第二个字符是否是大写，
     * 如果都是大写，那么剩余的也必须是大写，
     * 如果都不是大写的，那么所有的字符都需要小写
     * 如果第一个字符大写，第二个小写，那么剩余的也都需要小写
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;

        boolean firstIsUpper = false;
        boolean secondIsUpper = false;
        if ('Z' - word.charAt(0) >= 0)//首字母大写
            firstIsUpper = true;
        if ('Z' - word.charAt(1) >= 0) {//第二个字母大写
            secondIsUpper = true;
        }
        for (int i = 1; i < word.length(); i++) {
            if (firstIsUpper) {//首字母大写
                if (secondIsUpper) {//第二个字母大写，那么剩余的都需要大写
                    if ('Z' - word.charAt(i) < 0)
                        return false;
                } else {
                    if ('Z' - word.charAt(i) >= 0)//第二个字母是小写的，所以剩余的也必须是小写的
                        return false;
                }
            } else {//首字母小写 剩余的只要有大写字母就返回false
                if ('Z' - word.charAt(i) >= 0) {
                    return false;
                }
            }
        }
        return true;
    }

//    /**
//     * 解法二
//     * 先统计大写字母的数量
//     * 如果没有大写字母或者数量和字符串长度相等，就是合法
//     * 如果只有1个并且就是第一个 也是合法，
//     * 其他情况都是不合法的
//     * 这种解法思路更清晰，比第一种实现的效率也要高，少了很多判断逻辑
//     *
//     * @param word
//     * @return
//     */
//    public boolean detectCapitalUse(String word) {
//        int count = 0;
//        for (int i = 0; i < word.length(); i++) {
//            if ('Z' - word.charAt(i) >= 0)
//                count++;
//        }
//        if (count == 0 || count == word.length())
//            return true;
//        else if (count == 1 && 'Z' - word.charAt(0) >= 0)
//            return true;
//        else
//            return false;
//    }

    public static void main(String[] args) {
//        String str = "USA";
//        String str = "FlaG";
        String str = "leetcode";
        _520_Detect_Capital detect_capital = new _520_Detect_Capital();
        System.out.println(detect_capital.detectCapitalUse(str));
    }

}
