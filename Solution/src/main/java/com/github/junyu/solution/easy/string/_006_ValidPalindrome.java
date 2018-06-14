package com.github.junyu.solution.easy.string;


/**
 * @author ShaoJunyu
 * @since 2018/6/14 11:49
 */
public class _006_ValidPalindrome {



   /*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty string as valid palindrome.

    Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true
    Example 2:

    Input: "race a car"
    Output: false
    */


    /**
     * 有效的回文，顺读倒读内容一致
     * 思路：将字符串转为数组，遍历数组判断每个字符是否为数字或者字母。如果满足条件就往该字节数组的第[count]位置
     * 插入，count从0开始，count并不会出现越界等问题。筛选完数字字母后，最差的情况就是整个数组都是数字和字母，用
     * count做为有效内容的长度，再进行遍历，只需遍历整体的一半长度（收尾一一匹配）就能确定是否符合回文的规则。由于
     * 是忽略大小写的，所以在覆盖字节数组的过程中，还需要进行大小写的转换
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        char cs[] = s.toCharArray();
        int count = 0;
        char temp;
        for (int i = 0; i < cs.length; i++) {
            temp = cs[i];
            if ((temp >= '0' && temp <= '9') || (temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')) {
                cs[count] = toLowerCase(temp);
                count++;
            }
        }

        int mid = count / 2;
        for (int i = 0; i < mid; i++) {
            if (cs[i] != cs[count - 1 - i])
                return false;
        }

        return true;
    }

    /**
     * 将大写字符转为小写，相对于string的toLowerCase效率更高
     *
     * @param c
     * @return
     */
    private static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 'a' - 'A');
        }
        return c;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        String s = "11";

        System.out.println(isPalindrome(s));
    }
}
