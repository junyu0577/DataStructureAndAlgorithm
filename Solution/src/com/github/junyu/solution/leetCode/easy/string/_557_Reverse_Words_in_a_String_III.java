package com.github.junyu.solution.leetCode.easy.string;


public class _557_Reverse_Words_in_a_String_III {


   /* Given a string, you need to reverse the order of characters in each word within a
    sentence while still preserving whitespace and initial word order.

            Example 1:
    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
    Note: In the string, each word is separated by single space and there will not be any extra
    space in the string.*/

    /**
     * 字符串的局部反转
     * 定一个start指针指向第一个元素，在遍历字符数组的时候，将i作为要反转字符串的结束位置，遇到空格就对i-1和start区域的时候进行反转，反转以后
     * start就更新到i+1的位置。在最后依然要进行一次从start到数组末尾的反转，因为末尾结束的字符不一定是字符串.如果末尾是空格，那么会因为start大于数组的长度而不会
     * 进入循环。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";

        int start = 0;
        char cs[] = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                reverse(cs, start, i - 1);
                start = i + 1;
            }
        }
        reverse(cs, start, cs.length - 1);
        return new String(cs);
    }

    private void reverse(char[] cs, int left, int right) {
        while (left <= right) {
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
//        String str = " ";
        System.out.println(new _557_Reverse_Words_in_a_String_III().reverseWords(str));
    }
}
