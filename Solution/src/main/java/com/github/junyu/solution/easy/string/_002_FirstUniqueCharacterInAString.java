package com.github.junyu.solution.easy.string;


/**
 * @author ShaoJunyu
 * @since 2018/6/13 15:45
 */
public class _002_FirstUniqueCharacterInAString {

   /*
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:

    s = "leetcode"
            return 0.

    s = "loveleetcode",
            return 2.
    Note: You may assume the string contain only lowercase letters.

    */

    /**
     * 思路：定义一个长度为26得数组，里面存放对应得26个字母出现得次数
     * 最后遍历字符数组，在存放字数得数组值为1得时候，当前索引所对应得字母就是唯一得
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {

        int arr[] = new int[26];
        char cs[] = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            arr[cs[i]-'a']++;
        }
        for (int i=0;i<cs.length;i++){
            if (arr[cs[i]-'a']==1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        String s = "hello";
//        String s = "aaaa";
//        String s = "abb";
        String s = "bba";
        System.out.println(firstUniqChar(s));
    }
}
