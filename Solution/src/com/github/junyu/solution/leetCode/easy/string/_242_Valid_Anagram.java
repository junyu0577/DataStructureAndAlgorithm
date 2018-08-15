package com.github.junyu.solution.leetCode.easy.string;

/**
 * @author ShaoJunyu
 * @since 2018/6/14 09:16
 */
public class _242_Valid_Anagram {

   /*
    Given two strings s and t , write a function to determine if t is an anagram of s.

    Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true
    Example 2:

    Input: s = "rat", t = "car"
    Output: false
    Note:
    You may assume the string contains only lowercase alphabets.

    Follow up:
    What if the inputs contain unicode characters? How would you adapt your solution to such case?

    */

//    /**
//     * 对两个字节数组进行排序，然后比较字符串是否相同
//     * @param s
//     * @param t
//     * @return
//     */
//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//
//        char[] ss = s.toCharArray();
//        char[] tt = t.toCharArray();
//
//
//        Arrays.sort(ss);
//        Arrays.sort(tt);
//
//        if (String.valueOf(ss).equals(String.valueOf(tt))) {
//            return true;
//        }
//
//        return false;
//    }

    /**
     * 定义一个长度为26得数组存放每个字母出现得字数，遍历s字节数组进行元素得累增操作，
     * 再遍历t数组进行递减操作，当增减完某一个元素得值小于0就表示两个字符串不相同。
     * 这种方式少了两次快排，在效率上要优于上面得解决方案
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int nums[] = new int[26];
        for (char temp : s.toCharArray()) {
            nums[temp - 'a']++;
        }

        for (char temp : t.toCharArray()) {
            nums[temp - 'a']--;
            if (nums[temp - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "tomcatomm", t = "tomm";
        System.out.println(isAnagram(s, t));
    }
}
