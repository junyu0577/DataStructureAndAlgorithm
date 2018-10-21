package com.github.junyu.solution.leetCode.easy.string;

public class _925_Long_Pressed_Name {

   /* Your friend is typing his name into a keyboard.  Sometimes, when typing a character c,
    the key might get long pressed, and the character will be typed 1 or more times.

    You examine the typed characters of the keyboard.  Return True if it is possible
    that it was your friends name, with some characters (possibly none) being long pressed.



    Example 1:

    Input: name = "alex", typed = "aaleex"
    Output: true
    Explanation: 'a' and 'e' in 'alex' were long pressed.
    Example 2:

    Input: name = "saeed", typed = "ssaaedd"
    Output: false
    Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
    Example 3:

    Input: name = "leelee", typed = "lleeelee"
    Output: true
    Example 4:

    Input: name = "laiden", typed = "laiden"
    Output: true
    Explanation: It's not necessary to long press any character.


    Note:

    name.length <= 1000
    typed.length <= 1000
    The characters of name and typed are lowercase letters.*/


    /**
     * 你的朋友想要在键盘输出他的名字，但是可能由于长按键盘导致某些字母被打印多次，
     * 如果最后typed就是朋友的名字，只是某些字母打印不只一次（由于长按造成的），就返回true。
     * 思路：定义两个指针，分别指向两个字符串的头部，并在最开始时记录下名字的第一个字符，在循环中，
     * 如果两个字符串的当前所指位置的字符相同，就都指向下一个字符，并更新name的上一个字符。
     * 当两个指针指向的字符不同时，判断当前type所指的字符和上一个记录的字符是否相同，相同则说明
     * 是长按造成的重复输入，否则直接返回false。
     * 最后，需要检查p1是否已经到达了name的末尾，如果没到达，则说明不匹配。
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {

        if (name == null || typed == null)
            return false;

        if ("".equals(name) || "".equals(typed))
            return false;

        int p1 = 0;
        int p2 = 0;
        char lastChar = name.charAt(p1);
        while (p1 < name.length() && p2 < typed.length()) {
            if (name.charAt(p1) == typed.charAt(p2)) {
                lastChar = name.charAt(p1);
                p1++;
                p2++;
            } else if ((typed.charAt(p2) == lastChar)) {
                p2++;
            } else {
                return false;
            }
        }

        if (p1 < name.length()) {
            return false;
        }

        return true;

    }


    public static void main(String[] args) {
        _925_Long_Pressed_Name long_pressed_name = new _925_Long_Pressed_Name();
//        System.out.println(long_pressed_name.isLongPressedName("alex", "aaleex"));
//        System.out.println(long_pressed_name.isLongPressedName("saeed", "ssaaedd"));
//        System.out.println(long_pressed_name.isLongPressedName("leelee", "lleeelee"));
//        System.out.println(long_pressed_name.isLongPressedName("laiden", "laiden"));
        System.out.println(long_pressed_name.isLongPressedName("pyplrz", "ppyypllr"));

    }
}
