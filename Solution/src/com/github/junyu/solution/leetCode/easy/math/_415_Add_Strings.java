package com.github.junyu.solution.leetCode.easy.math;


public class _415_Add_Strings {

   /* Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

    Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.*/


    /**
     * 两个字符串求和，要求不能直接将字符串转为Integer
     * 先将字符串转为字符数组，并定义p1和p2指针分别指向cs1和cs2的末尾，
     * 创建一个cs数组用来存放cs1和cs2中元素相加的结果，remain保存的是进位，如果两数相加
     * 大于9，那么remain就要更新为1，否则为0，因为每次计算当前cs中要保存的元素值时，都需要加上remain的值
     * 再最后，可能存在第一位数的进位，所以手动再添加上1在最前面
     *
     *
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        char cs1[] = num1.toCharArray();
        char cs2[] = num2.toCharArray();
        int maxIndex = cs1.length > cs2.length ? cs1.length : cs2.length;
        char cs[] = new char[maxIndex];
        int p1 = cs1.length - 1;
        int p2 = cs2.length - 1;
        int remain = 0;
        while (p1 >= 0 || p2 >= 0) {
            int x = 0;
            int y = 0;
            if (p1 >= 0) {
                x = (cs1[p1] - '0');
            }
            if (p2 >= 0) {
                y = (cs2[p2] - '0');
            }
            int num = x + y + remain;
            cs[--maxIndex] = (char) ((num % 10) + '0');
            if (num > 9) {
                remain = 1;
            } else {
                remain = 0;
            }
            p1--;
            p2--;
        }
        String res = new String(cs);
        if (remain == 1) {
            res = "1" + res;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new _415_Add_Strings().addStrings("83", "9"));
        System.out.println(new _415_Add_Strings().addStrings("9", "1"));
        System.out.println(new _415_Add_Strings().addStrings("9", "99"));
        System.out.println(new _415_Add_Strings().addStrings("11", "12"));
        System.out.println(new _415_Add_Strings().addStrings("0", "0"));
        System.out.println(new _415_Add_Strings().addStrings("6913259244", "71103343"));
    }

}
