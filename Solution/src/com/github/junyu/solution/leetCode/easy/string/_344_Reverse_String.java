package com.github.junyu.solution.leetCode.easy.string;


/**
 * @author ShaoJunyu
 * @since 2018/6/13 12:57
 */
public class _344_Reverse_String {

   /*
    Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".
    */

//    public static String reverseString(String s) {
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            sb.append(s.charAt(i));
//        }
//        return sb.toString();
//    }

    /**
     * 将字符串转字符数组进行遍历，遍历得字数为数组长度得1/2，进行缩进式得交换
     * @param s
     * @return
     */
    public static String reverseString(String s) {

        char arr[] = s.toCharArray();
        int length = arr.length - 1;
        int mid = (length + 1) / 2;
        char temp;
        for (int i = 0; i < mid; i++) {
            temp = arr[i];
            arr[i] = arr[length - i];
            arr[length - i] = temp;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
//        String s = "hello";
        String s = "jack";
        System.out.println(reverseString(s));
    }

}
