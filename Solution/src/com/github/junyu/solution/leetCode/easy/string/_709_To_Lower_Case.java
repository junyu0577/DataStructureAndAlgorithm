package com.github.junyu.solution.leetCode.easy.string;

public class _709_To_Lower_Case {

/*
    Example 1:

    Input: "Hello"
    Output: "hello"
    Example 2:

    Input: "here"
    Output: "here"
    Example 3:

    Input: "LOVELY"
    Output: "lovely"*/


    /**
     * 大写转小写
     * 这题要是直接使用toLowerCase,感觉都没必要出了
     * 自己实现一个简单的转换只需要判断当前字母是否是大写，如果是大写就利用ascii表中'a'和'A'之间差值加上当前的大写字母，
     * 就得到了所需要的小写字母
     *
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        char cs[] = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'A' && cs[i] <= 'Z')
                cs[i] = (char) ('a' - 'A' + str.charAt(i));
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        _709_To_Lower_Case to_lower_case = new _709_To_Lower_Case();
        System.out.println(to_lower_case.toLowerCase("Hello"));
    }

}
